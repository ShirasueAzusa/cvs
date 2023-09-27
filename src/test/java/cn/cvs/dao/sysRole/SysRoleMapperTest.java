package cn.cvs.dao.sysRole;

import cn.cvs.pojo.SysRole;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class SysRoleMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    @Test
    void add() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            SysRole sysRole = new SysRole();
            sysRole.setCode("testCode");
            sysRole.setRoleName("testName");
            sysRole.setCreatedUserId(1);
            sysRole.setCreatedTime(new Date());
            int result = sqlSession.getMapper(SysRoleMapper.class).add(sysRole);
            logger.debug("result: {}", result);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    void update() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            SysRole sysRole = new SysRole();
            sysRole.setId(1);
            sysRole.setCode("testCode");
            sysRole.setRoleName("testName");
            sysRole.setUpdateUserId(1);
            sysRole.setUpdateTime(new Date());
            int result = sqlSession.getMapper(SysRoleMapper.class).update(sysRole);
            logger.debug("result: {}", result);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    void delete() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            int result = sqlSession.getMapper(SysRoleMapper.class).delete(1);
            logger.debug("result: {}", result);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    void testSelectByPage() {
        SqlSession sqlSession = null;
        List<SysRole> roleList;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            String roleName = "";
            int pageIndex = 2;
            int pageSize = 2;
            Integer pageBegin = (pageIndex - 1) * pageSize;//计算查询起始位置
            roleList = sqlSession.getMapper(SysRoleMapper.class).selectByPage(roleName, pageBegin, pageSize);   //查询分页数据
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.info("查询到角色数量：" + roleList.size());
        for (SysRole role : roleList) {
            logger.info("查询到角色信息：" + role);
        }
    }
}