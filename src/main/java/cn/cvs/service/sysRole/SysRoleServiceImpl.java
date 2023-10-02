package cn.cvs.service.sysRole;

import cn.cvs.dao.sysRole.SysRoleMapper;
import cn.cvs.pojo.SysRole;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    private SysRoleMapper mapper;

    @Override
    public int add(SysRole sysRole) {
        return mapper.add(sysRole);
    }

    @Override
    public int update(SysRole sysRole) {
        return mapper.update(sysRole);
    }

    @Override
    public int delete(int roleId) {
        return mapper.delete(roleId);
    }

    @Override
    public List<SysRole> selectByPage(String roleName, Integer pageBegin, Integer pageSize) {
        return mapper.selectByPage(roleName, pageBegin, pageSize);
    }
}
