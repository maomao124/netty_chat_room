package mao.chat_room_server_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.handler.DefaultGlobalExceptionHandler;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_core.exception.ExceptionCode;
import mao.tools_core.utils.StrPool;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.config
 * Class(类名): DefaultRPCGlobalExceptionHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/31
 * Time(创建时间)： 22:57
 * Version(版本): 1.0
 * Description(描述)： RPC全局异常处理
 */

@Slf4j
public class DefaultRPCGlobalExceptionHandler extends DefaultGlobalExceptionHandler
{
    /**
     * 业务异常
     *
     * @param ex      业务异常
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(BizException.class)
    public R<String> bizException(BizException ex, HttpServletRequest request)
    {
        log.warn("BizException:", ex);
        R<String> r = R.result(ex.getCode(), StrPool.EMPTY, ex.getMessage()).setPath(request.getRequestURI());
        r.setData(null);
        return r;
    }

    /**
     * jsr 规范中的验证异常
     *
     * @param ex      jsr 规范中的验证异常
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R<String> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request)
    {
        log.warn("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        R<String> r = R.result(ExceptionCode.BASE_VALID_PARAM.getCode(), StrPool.EMPTY, message).setPath(request.getRequestURI());
        return r.setData(null);
    }

    /**
     * 其他异常
     *
     * @param ex      Exception
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(Exception.class)
    public R<String> otherExceptionHandler(Exception ex, HttpServletRequest request)
    {
        log.warn("Exception:", ex);
        if (ex.getCause() instanceof BizException)
        {
            return this.bizException((BizException) ex.getCause(), request);
        }
        return R.result(ExceptionCode.SYSTEM_BUSY.getCode(), StrPool.EMPTY,
                ExceptionCode.SYSTEM_BUSY.getMsg()).setPath(request.getRequestURI()).setData(null);
    }


    /**
     * 不支持异常处理http请求异常
     * 返回状态码:405
     *
     * @param ex      HttpRequestMethodNotSupportedException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
                                                                  HttpServletRequest request)
    {
        log.warn("HttpRequestMethodNotSupportedException:", ex);
        return R.result(ExceptionCode.METHOD_NOT_ALLOWED.getCode(), StrPool.EMPTY,
                ExceptionCode.METHOD_NOT_ALLOWED.getMsg()).setPath(request.getRequestURI()).setData(null);
    }


    /**
     * 持久性异常
     *
     * @param ex      PersistenceException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(PersistenceException.class)
    public R<String> persistenceException(PersistenceException ex, HttpServletRequest request)
    {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof BizException)
        {
            BizException cause = (BizException) ex.getCause();
            return R.result(cause.getCode(), StrPool.EMPTY, cause.getMessage());
        }
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI()).setData(null);
    }

    /**
     * mybatis系统异常
     *
     * @param ex      MyBatisSystemException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(MyBatisSystemException.class)
    public R<String> myBatisSystemException(MyBatisSystemException ex, HttpServletRequest request)
    {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof PersistenceException)
        {
            return this.persistenceException((PersistenceException) ex.getCause(), request);
        }
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI()).setData(null);
    }
}
