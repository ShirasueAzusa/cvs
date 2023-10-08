package cn.cvs.dao.storageRecord;

import cn.cvs.pojo.StorageRecord;
import cn.cvs.service.storageRecord.StorageRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
class StorageRecordMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    private StorageRecordService service;

    @Autowired
    public void setService(StorageRecordService service) {
        this.service = service;
    }

    @Test
    void testGetStorageRecordList() {
        List<Integer> supplierIdList = Arrays.asList(1, 2);
        List<StorageRecord> storageRecordList = service.getStorageRecordList(supplierIdList);

        for (StorageRecord storageRecord : storageRecordList) {
            logger.debug(storageRecord.toString());
            logger.debug(storageRecord.getSupplier().toString());
        }
    }
}