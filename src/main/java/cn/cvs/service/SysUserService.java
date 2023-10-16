package cn.cvs.service;

import cn.cvs.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    /**
     * 用户登录
     *
     * @param account
     * @param userPassword
     * @return
     */
    SysUser login(String account, String userPassword);

    /**
     * 根据条件查询用户列表
     *
     * @param realName
     * @param roleId
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<SysUser> selectList(String realName, Integer roleId, Integer pageNo, Integer pageSize);

    /**
     * 根据条件查询用户表记录数
     *
     * @param realName
     * @param roleId
     * @return
     */
    int selectCount(String realName, Integer roleId);

    /**
     * 新增用户信息
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 根据ID查找user
     *
     * @param id
     * @return
     */
    SysUser selectById(Integer id);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int update(SysUser user);
}
