package cn.cvs.dao.sysUser;


import cn.cvs.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    List<SysUser> selectSysUserList(@Param("sysUser") SysUser sysUser);

    /**
     * 保存用户
     */
    boolean add(SysUser sysUser);
}
