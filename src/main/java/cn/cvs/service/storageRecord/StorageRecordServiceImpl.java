package cn.cvs.service.storageRecord;

import cn.cvs.dao.storageRecord.StorageRecordMapper;
import cn.cvs.pojo.StorageRecord;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Setter
@Service("storageRecordService")
public class StorageRecordServiceImpl implements StorageRecordService {
    private StorageRecordMapper mapper;

    @Override
    public List<StorageRecord> getStorageRecordList(Map<String, Object> supplierId) {
        return mapper.getStorageRecordList(supplierId);
    }
}
