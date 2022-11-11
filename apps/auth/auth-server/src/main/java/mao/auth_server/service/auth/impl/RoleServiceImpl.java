package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.RoleSaveDTO;
import mao.auth_entity.dto.auth.RoleUpdateDTO;
import mao.auth_entity.entity.auth.Role;
import mao.auth_server.dao.auth.RoleMapper;
import mao.auth_server.service.auth.RoleOrgService;
import mao.auth_server.service.auth.RoleService;
import mao.toolsdozer.utils.DozerUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): RoleServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 角色服务实现类
 */

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService
{
    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private RoleOrgService roleOrgService;



    @Override
    public boolean removeById(List<Long> ids)
    {
        return false;
    }

    @Override
    public List<Role> findRoleByUserId(Long userId)
    {
        return null;
    }

    @Override
    public void saveRole(RoleSaveDTO data, Long userId)
    {

    }

    @Override
    public void updateRole(RoleUpdateDTO role, Long userId)
    {

    }

    @Override
    public List<Long> findUserIdByCode(String[] codes)
    {
        return null;
    }

    @Override
    public Boolean check(String code)
    {
        return null;
    }
}
