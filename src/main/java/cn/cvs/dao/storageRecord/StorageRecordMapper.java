package cn.cvs.dao.storageRecord;

import cn.cvs.pojo.StorageRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StorageRecordMapper {
    List<StorageRecord> getStorageRecordList(@Param("supplierIdList") Map<String, Object> supplierId);
}
