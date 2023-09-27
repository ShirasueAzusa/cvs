package cn.cvs.service;

import cn.cvs.pojo.SysUser;

import java.util.List;

/**
 * 用户模块业务层接口
 */
public interface SysUserService {
    List<SysUser> getList(SysUser sysUser);

    /**
     * 保存用户
     */
    boolean add(SysUser sysUser);
}
