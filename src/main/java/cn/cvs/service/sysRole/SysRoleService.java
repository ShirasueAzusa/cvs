package cn.cvs.service.sysRole;

import cn.cvs.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    int add(SysRole sysRole);

    int update(SysRole sysRole);

    int delete(int roleId);

    List<SysRole> selectByPage(String roleName, Integer pageBegin, Integer pageSize);
}
