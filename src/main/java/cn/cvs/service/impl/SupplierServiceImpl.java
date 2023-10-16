package cn.cvs.service.impl;

import cn.cvs.mapper.supplier.SupplierMapper;
import cn.cvs.pojo.Supplier;
import cn.cvs.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    SupplierMapper supplierMapper;

    @Autowired
    public void setSupplierMapper(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    @Override
    public List<Supplier> selectAll(int pageNo, int pageSize, String supCode, String supName) {
        int pageBegin = (pageNo - 1) * pageSize;
        return supplierMapper.selectAll(pageBegin, pageSize, supCode, supName);
    }

    @Override
    public int selectCount(String supCode, String supName) {
        return supplierMapper.selectCount(supCode, supName);
    }
}
