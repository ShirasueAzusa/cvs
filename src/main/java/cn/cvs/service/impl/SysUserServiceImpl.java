package cn.cvs.service.impl;

import cn.cvs.mapper.sysUser.SysUserMapper;
import cn.cvs.pojo.SysUser;
import cn.cvs.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    SysUserMapper sysUserMapper;

    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser login(String account, String userPassword) {
        SysUser sysUser = sysUserMapper.selectByAccount(account);
        if (null != sysUser) {
            if (!sysUser.getPassword().equals(userPassword)) {
                sysUser = null;
            }
        }
        return sysUser;
    }

    @Override
    public List<SysUser> selectList(String realName, Integer roleId, Integer pageNo, Integer pageSize) {
        int pageBegin = (pageNo - 1) * pageSize;
        return sysUserMapper.selectList(realName, roleId, pageBegin, pageSize);
    }

    @Override
    public int selectCount(String realName, Integer roleId) {
        return sysUserMapper.selectCount(realName, roleId);
    }

    @Override
    public int insert(SysUser sysUser) {
        sysUser.setCreatedTime(new Date());
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public int update(SysUser sysUser) {
        sysUser.setUpdatedTime(new Date());
        return sysUserMapper.update(sysUser);
    }
}
