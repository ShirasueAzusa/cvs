package cn.cvs.dao.storageRecord;

import cn.cvs.pojo.StorageRecord;
import cn.cvs.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StorageRecordMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    @Test
    void testGetStorageRecordList() {
        SqlSession sqlSession = null;
        List<StorageRecord> storageRecordList;
        try {
            sqlSession = MyBatisUtil.createSqlSession();
            List<Integer> supplierIdList = new ArrayList<>();
            Map<String, Object> supplierIdMap = new HashMap<>();
            supplierIdMap.put("supplierIdList", supplierIdList);
            storageRecordList = sqlSession.getMapper(StorageRecordMapper.class).getStorageRecordList(supplierIdMap);
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSqlSession(sqlSession);
            }
        }
        for (StorageRecord storageRecord : storageRecordList) {
            logger.debug(storageRecord.toString());
            logger.debug(storageRecord.getSupplier().toString());
        }
    }
}