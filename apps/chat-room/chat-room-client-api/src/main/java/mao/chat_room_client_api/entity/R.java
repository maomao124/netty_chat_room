package mao.chat_room_client_api.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_client_api.entity
 * Class(类名): R
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 21:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Getter
@Setter
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
@Accessors(chain = true)
public class R<T>
{
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;
    /**
     * 统一参数验证异常
     */
    public static final int VALID_EX_CODE = -9;
    public static final int OPERATION_EX_CODE = -10;
    /**
     * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
     */
    private int code;

    /**
     * 调用结果
     */
    private T data;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    private String msg = "ok";

    private String path;
    /**
     * 附加数据
     */
    private Map<String, Object> extra;

    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();

    private R()
    {
        super();
    }

    /**
     * 构造方法
     *
     * @param code 代码
     * @param data 数据
     * @param msg  消息
     */
    public R(int code, T data, String msg)
    {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 得到数据
     *
     * @return {@link T}
     */
    public T getData()
    {
        return data;
    }

    /**
     * 得到数据
     *
     * @param clazz clazz
     * @return {@link E}
     */
    public <E> E getData(Class<E> clazz)
    {
        String json = data.toString();
        return JSON.parseObject(json, clazz);
    }

    /**
     * 得到数据数组
     *
     * @param dataClass 数据类
     * @return {@link List}<{@link D}>
     */
    public <D> List<D> getDataArray(Class<D> dataClass)
    {
        String json = data.toString();
        return JSON.parseArray(json, dataClass);
    }

    /**
     * 结果
     *
     * @param code 代码
     * @param data 数据
     * @param msg  消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> result(int code, E data, String msg)
    {
        return new R<>(code, data, msg);
    }

    /**
     * 请求成功消息
     *
     * @param data 结果
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data)
    {
        return new R<>(SUCCESS_CODE, data, "ok");
    }

    /**
     * 成功
     *
     * @return {@link R}<{@link Boolean}>
     */
    public static R<Boolean> success()
    {
        return new R<>(SUCCESS_CODE, true, "ok");
    }

    /**
     * 请求成功方法 ，data返回值，msg提示信息
     *
     * @param data 结果
     * @param msg  消息
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data, String msg)
    {
        return new R<>(SUCCESS_CODE, data, msg);
    }

    /**
     * 请求失败消息
     *
     * @param code 错误代码
     * @param msg  消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(int code, String msg)
    {
        return new R<>(code, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    /**
     * 失败
     *
     * @param msg 消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(String msg)
    {
        return fail(OPERATION_EX_CODE, msg);
    }

    /**
     * 失败
     *
     * @param msg  消息
     * @param args 参数
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(String msg, Object... args)
    {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new R<>(OPERATION_EX_CODE, null, String.format(message, args));
    }


    /**
     * 请求失败消息，根据异常类型，获取不同的提供消息
     *
     * @param throwable 异常
     * @return RPC调用结果
     */
    public static <E> R<E> fail(Throwable throwable)
    {
        return fail(FAIL_CODE, throwable != null ? throwable.getMessage() : DEF_ERROR_MESSAGE);
    }

    public static <E> R<E> validFail(String msg)
    {
        return new R<>(VALID_EX_CODE, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    public static <E> R<E> validFail(String msg, Object... args)
    {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new R<>(VALID_EX_CODE, null, String.format(message, args));
    }


    public static <E> R<E> timeout()
    {
        return fail(TIMEOUT_CODE, HYSTRIX_ERROR_MESSAGE);
    }


    public R<T> put(String key, Object value)
    {
        if (this.extra == null)
        {
            this.extra = Maps.newHashMap();
        }
        this.extra.put(key, value);
        return this;
    }

    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    public Boolean getIsSuccess()
    {
        return this.code == SUCCESS_CODE || this.code == 200;
    }

    /**
     * 逻辑处理是否失败
     *
     * @return {@link Boolean}
     */
    public Boolean getIsError()
    {
        return !getIsSuccess();
    }

    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
}
