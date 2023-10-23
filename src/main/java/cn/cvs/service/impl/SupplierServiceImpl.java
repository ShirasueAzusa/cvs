package cn.cvs.service.impl;

import cn.cvs.mapper.supplier.SupplierMapper;
import cn.cvs.pojo.Supplier;
import cn.cvs.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public int insert(Supplier supplier) {
        supplier.setCreatedTime(new Date());
        return supplierMapper.insert(supplier);
    }

    @Override
    public Supplier selectOne(Integer id) {
        return supplierMapper.selectOne(id);
    }

    @Override
    public int update(Supplier supplier) {
        supplier.setUpdatedTime(new Date());
        return supplierMapper.update(supplier);
    }
}
