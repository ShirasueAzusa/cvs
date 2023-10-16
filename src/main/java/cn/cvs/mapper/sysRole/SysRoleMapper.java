package cn.cvs.mapper.sysRole;

import cn.cvs.pojo.SysRole;

import java.util.List;

public interface SysRoleMapper {
    /**
     * 获取角色列表
     *
     * @return
     */
    List<SysRole> selectList();
}
