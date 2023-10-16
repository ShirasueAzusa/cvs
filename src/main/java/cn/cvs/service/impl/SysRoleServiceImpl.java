package cn.cvs.service.impl;

import cn.cvs.mapper.sysRole.SysRoleMapper;
import cn.cvs.pojo.SysRole;
import cn.cvs.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    SysRoleMapper sysRoleMapper;

    @Autowired
    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public List<SysRole> selectList() {
        return sysRoleMapper.selectList();
    }
}
