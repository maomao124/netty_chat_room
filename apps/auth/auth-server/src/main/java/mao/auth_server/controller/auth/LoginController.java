package mao.auth_server.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.auth_server.service.auth.ValidateCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): LoginController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 登录Controller
 */

@RestController
@RequestMapping("/anno")
@Api(value = "LoginController", tags = "登录控制器")
public class LoginController
{
    @Resource
    private ValidateCodeService validateCodeService;


    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException
    {
        this.validateCodeService.create(key, response);
    }
}
