package cn.cvs.service.sysUser;

import cn.cvs.dao.sysUser.SysUserMapper;
import cn.cvs.pojo.SysUser;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户模块业务层实现
 */
@Setter
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper mapper;

    @Override
    public List<SysUser> getList(SysUser sysUser) {
        return mapper.selectSysUserList(sysUser);
    }

    @Override
    public boolean add(SysUser sysUser) {
        return mapper.add(sysUser);
    }
}
