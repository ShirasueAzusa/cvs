package cn.cvs.service;

import cn.cvs.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {
    /**
     * 用户登录
     */
    SysUser login(String account, String userPassword);

    /**
     * 根据条件查询用户列表
     */
    List<SysUser> selectList(String realName, Integer roleId, Integer pageNo, Integer pageSize);

    /**
     * 根据条件查询用户表记录数
     */
    int selectCount(String realName, Integer roleId);

    /**
     * 新增用户信息
     */
    int insert(SysUser sysUser);

    /**
     * 根据ID查找user
     */
    SysUser selectById(Integer id);

    /**
     * 修改用户信息
     */
    int update(SysUser user);

    /**
     * 根据用户名查询用户信息
     */
    SysUser selectByAccount(@Param("account") String account);
}
