package cn.cvs.service;

import cn.cvs.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 获取角色列表
     *
     * @return
     */
    List<SysRole> selectList();
}
