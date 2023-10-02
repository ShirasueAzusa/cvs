package cn.cvs.dao.storageRecord;

import cn.cvs.pojo.StorageRecord;
import cn.cvs.service.storageRecord.StorageRecordService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
class StorageRecordMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private ApplicationContext context;

    StorageRecordService service = (StorageRecordService) context.getBean("StorageRecordService");

    @Test
    void testGetStorageRecordList() {
        SqlSession sqlSession = null;
        List<Integer> supplierIdList = new ArrayList<>();
        Map<String, Object> supplierIdMap = new HashMap<>();
        supplierIdMap.put("supplierIdList", supplierIdList);
        List<StorageRecord> storageRecordList = service.getStorageRecordList(supplierIdMap);

        for (StorageRecord storageRecord : storageRecordList) {
            logger.debug(storageRecord.toString());
            logger.debug(storageRecord.getSupplier().toString());
        }
    }
}