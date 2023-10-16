package cn.cvs.mapper.sysUser;

import cn.cvs.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param account
     * @return
     */
    SysUser selectByAccount(@Param("account") String account);

    /**
     * 通过条件查询用户记录
     *
     * @param realName
     * @param roleId
     * @param pageBegin
     * @param pageSize
     * @return
     */
    List<SysUser> selectList(@Param("realName") String realName,
                             @Param("roleId") Integer roleId, @Param("pageBegin") Integer pageBegin,
                             @Param("pageSize") Integer pageSize);


    /**
     * 通过条件查询-用户表记录数
     *
     * @param realName
     * @param roleId
     * @return
     */
    int selectCount(@Param("realName") String realName, @Param("roleId")
    Integer roleId);

    /**
     * 新增用户信息
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);


    /**
     * 通过id获取user
     *
     * @param id
     * @return
     */
    SysUser selectById(@Param("id") Integer id);

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    int update(SysUser sysUser);
}
