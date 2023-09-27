package cn.cvs.dao.supplier;

import cn.cvs.pojo.StorageRecord;
import cn.cvs.pojo.Supplier;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class SupplierMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    @Test
    void count() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            int count = sqlSession.getMapper(SupplierMapper.class).count();
            logger.debug("SysUserMapperTest count ---> " + count);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
    }

    @Test
    void getSupplierList() throws Exception {
        SqlSession sqlSession = null;
        List<Supplier> supplierList;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            String supCode = null;
            String supName = null;
            String supContact = null;
            String createdTime = "";
            supplierList = sqlSession.getMapper(SupplierMapper.class).getSupplierList(supCode, supName, supContact, createdTime);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
        if (supplierList != null) {
            for (Supplier supplier : supplierList) {
                logger.debug("testSupplierListQuery supName: " + supplier.getSupName() + " and supDesc: " + supplier.getSupDesc());
            }
        }
    }

    @Test
    void testInsert() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Supplier supplier = new Supplier();
            supplier.setSupCode("supplierCode");
            supplier.setSupName("supplierName");
            supplier.setSupDesc("supplierDesc");
            supplier.setSupContact("supplierContact");
            supplier.setSupPhone("supplierPhone");
            supplier.setSupAddress("supplierAddress");
            supplier.setSupFax("supplierFax");
            supplier.setCreatedUserId(1);
            supplier.setCreatedTime(new Date());
            int insert = sqlSession.getMapper(SupplierMapper.class).insert(supplier);
            sqlSession.commit();
            logger.debug("testInsert insert: " + insert);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
    }

    @Test
    void testUpdate() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            Supplier supplier = new Supplier();
            supplier.setId(16);
            supplier.setSupName("supplierNewName");
            supplier.setUpdatedUserId(1);
            supplier.setUpdatedTime(new Date());
            int update = sqlSession.getMapper(SupplierMapper.class).update(supplier);
            sqlSession.commit();
            logger.debug("testUpdate update: " + update);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
    }

    @Test
    void testDelete() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            int delete = sqlSession.getMapper(SupplierMapper.class).delete(16);
            sqlSession.commit();
            logger.debug("testDelete delete: " + delete);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
    }

    @Test
    void testGetSupplierListBySupId() {
        SqlSession sqlSession = null;
        List<Supplier> supplierList;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            supplierList = sqlSession.getMapper(SupplierMapper.class).getSupplierListBySupId(1);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
        for (Supplier supplier : supplierList) {
            logger.debug(supplier.toString());
            for (StorageRecord storageRecord : supplier.getStorageRecordList()) {
                logger.debug(storageRecord.toString());
            }
        }
    }
}