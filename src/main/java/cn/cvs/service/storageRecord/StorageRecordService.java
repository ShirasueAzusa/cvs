package cn.cvs.service.storageRecord;

import cn.cvs.pojo.StorageRecord;

import java.util.List;
import java.util.Map;

public interface StorageRecordService {
    List<StorageRecord> getStorageRecordList(Map<String, Object> supplierId);
}
