package cn.cvs.service;

import cn.cvs.dao.sysUser.SysUserMapper;
import cn.cvs.pojo.SysUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模块业务层实现
 */
@Getter
@Setter
@Transactional
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getList(SysUser sysUser) {
        try {
            return sysUserMapper.selectSysUserList(sysUser);
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
            throw e;
        }
    }

    /**
     * 保存用户
     */
    @Override
    public boolean add(SysUser sysUser) {
        boolean result = false;
        try {
            if (sysUserMapper.add(sysUser)) {
                result = true;
                //测试事务回滚时，打开注释
                //throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
            throw e;
        }
        return result;
    }
}
