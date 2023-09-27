package cn.cvs.dao.sysUser;

import cn.cvs.pojo.SysUser;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class SysUserMapperImpl extends SqlSessionDaoSupport implements SysUserMapper {
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser) {
        return getSqlSession().selectList("cn.cvs.dao.sysUser.SysUserMapper.selectSysUserList", sysUser);
    }

    /**
     * 保存用户
     */
    @Override
    public boolean add(SysUser sysUser) {
        return false;
    }
}
