package cn.cvs.dao.sysRole;

import cn.cvs.pojo.SysRole;
import cn.cvs.service.sysRole.SysRoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
class SysRoleMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    private SysRoleService service;

    @Autowired
    public void setService(SysRoleService service) {
        this.service = service;
    }

    @Test
    void add() {
        SysRole sysRole = new SysRole();
        sysRole.setCode("testCode");
        sysRole.setRoleName("testName");
        sysRole.setCreatedUserId(5);
        sysRole.setCreatedTime(new Date());

        logger.debug("result: {}", service.add(sysRole));
    }

    @Test
    void update() {
        SysRole sysRole = new SysRole();
        sysRole.setId(5);
        sysRole.setCode("testCode");
        sysRole.setRoleName("testName");
        sysRole.setUpdateUserId(1);
        sysRole.setUpdateTime(new Date());

        logger.debug("result: {}", service.update(sysRole));
    }

    @Test
    void delete() {
        logger.debug("result: {}", service.delete(6));
    }

    @Test
    void testSelectByPage() {
        String roleName = "";
        int pageIndex = 2;
        int pageSize = 2;
        Integer pageBegin = (pageIndex - 1) * pageSize;

        List<SysRole> roleList = service.selectByPage(roleName, pageBegin, pageSize);

        logger.info("查询到角色数量：" + roleList.size());
        for (SysRole role : roleList) {
            logger.info("查询到角色信息：" + role);
        }
    }
}