package cn.cvs.service.storageRecord;

import cn.cvs.pojo.StorageRecord;

import java.util.List;

public interface StorageRecordService {
    List<StorageRecord> getStorageRecordList(List<Integer> supplierId);
}
