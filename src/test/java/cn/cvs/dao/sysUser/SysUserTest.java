package cn.cvs.dao.sysUser;

import cn.cvs.pojo.SysUser;
import cn.cvs.service.sysUser.SysUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysUserTest {
    private final Logger logger = LogManager.getLogger(SysUserTest.class);

    @Autowired
    private ApplicationContext context;

    SysUserService userService = (SysUserService) context.getBean("sysUserService");

    @Test
    public void testGetUserList() {

        List<SysUser> userList;
        SysUser userCondition = new SysUser();
        userCondition.setRealName("赵");
        userCondition.setRoleId(2);
        userList = userService.getList(userCondition);

        for (SysUser userResult : userList) {
            logger.debug("testGetUserList "
                    + "account: " + userResult.getAccount()
                    + " and realName: " + userResult.getRealName()
                    + " and roleId: " + userResult.getRoleId()
                    + " and roleName: " + userCondition.getRealName()
                    + " and address: " + userResult.getAddress()
            );
        }
    }

    @Test
    public void testAddUser() {
        SysUserService userService = (SysUserService) context.getBean("sysUserService");

        SysUser user = new SysUser();
        //···
        boolean result = userService.add(user);
        logger.debug("testAdd result: " + result);
    }
}
