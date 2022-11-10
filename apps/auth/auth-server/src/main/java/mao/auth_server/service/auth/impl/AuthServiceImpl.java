package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_server.service.auth.AuthService;
import mao.tools_core.base.R;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): AuthServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService
{

    @Override
    public R<LoginDTO> login(String account, String password)
    {
        return null;
    }
}
