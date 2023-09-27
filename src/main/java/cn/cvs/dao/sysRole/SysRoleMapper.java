package cn.cvs.dao.sysRole;

import cn.cvs.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int add(SysRole sysRole);

    int update(SysRole sysRole);

    int delete(int roleId);

    List<SysRole> selectByPage(@Param("roleName") String roleName,
                               @Param("pageBegin") Integer pageBegin,
                               @Param("pageSize") Integer pageSize);
}
