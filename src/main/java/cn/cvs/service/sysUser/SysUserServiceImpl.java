package cn.cvs.service.sysUser;

import cn.cvs.dao.sysUser.SysUserMapper;
import cn.cvs.pojo.SysUser;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户模块业务层实现
 */
@Setter
@Service("sysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService {
    private SysUserMapper mapper;

    @Autowired
    public void setMapper(SysUserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SysUser> getList(SysUser sysUser) {
        return mapper.selectSysUserList(sysUser);
    }

    @Override
    public boolean add(SysUser sysUser) {
        return mapper.add(sysUser);
    }
}
