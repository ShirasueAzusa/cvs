package cn.cvs.service.storageRecord;

import cn.cvs.dao.storageRecord.StorageRecordMapper;
import cn.cvs.pojo.StorageRecord;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Service("storageRecordService")
@Transactional
public class StorageRecordServiceImpl implements StorageRecordService {
    private StorageRecordMapper mapper;

    @Autowired
    public void setMapper(StorageRecordMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<StorageRecord> getStorageRecordList(List<Integer> supplierId) {
        return mapper.getStorageRecordList(supplierId);
    }
}
