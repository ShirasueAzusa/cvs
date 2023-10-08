package cn.cvs.dao.supplier;

import cn.cvs.pojo.StorageRecord;
import cn.cvs.pojo.Supplier;
import cn.cvs.service.supplier.SupplierService;
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
class SupplierMapperTest {
    private final Logger logger = LogManager.getLogger(getClass());

    SupplierService service;

    @Autowired
    public void setService(SupplierService service) {
        this.service = service;
    }

    @Test
    void count() {
        logger.debug("SysUserMapperTest count ---> " + service.count());
    }

    @Test
    void getSupplierList() {
        List<Supplier> supplierList = service.getSupplierList(null, null, null, "2014-11-21 12:51:11");

        if (supplierList != null) {
            for (Supplier supplier : supplierList) {
                logger.debug("testSupplierListQuery supName: " + supplier.getSupName() + " and supDesc: " + supplier.getSupDesc());
            }
        }
    }

    @Test
    void testInsert() {
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

        logger.debug("testInsert insert: " + service.insert(supplier));
    }

    @Test
    void testUpdate() {
        Supplier supplier = new Supplier();
        supplier.setId(18);
        supplier.setSupName("supplierNewName");
        supplier.setUpdatedUserId(1);
        supplier.setUpdatedTime(new Date());

        logger.debug("testUpdate update: " + service.update(supplier));
    }

    @Test
    void testDelete() {
        logger.debug("testDelete delete: " + service.delete(18));
    }

    @Test
    void testGetSupplierListBySupId() {
        List<Supplier> supplierList = service.getSupplierListBySupId(1);

        for (Supplier supplier : supplierList) {
            logger.debug(supplier.toString());
            for (StorageRecord storageRecord : supplier.getStorageRecordList()) {
                logger.debug(storageRecord.toString());
            }
        }
    }
}