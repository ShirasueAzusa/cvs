package cn.cvs.mapper.storageRecord;

import cn.cvs.pojo.StorageRecord;

import java.util.List;

public interface StorageRecordMapper {
    /**
     * 查询所有入库记录
     *
     * @return
     */
    List<StorageRecord> selectAll();
}
