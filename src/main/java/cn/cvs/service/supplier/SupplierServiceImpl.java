package cn.cvs.service.supplier;

import cn.cvs.dao.supplier.SupplierMapper;
import cn.cvs.pojo.Supplier;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    private SupplierMapper mapper;

    @Override
    public int count() {
        return mapper.count();
    }

    @Override
    public List<Supplier> getSupplierList(String supCode, String supName, String supContact, String createdTime) {
        return mapper.getSupplierList(supCode, supName, supContact, createdTime);
    }

    @Override
    public int insert(Supplier supplier) {
        return mapper.insert(supplier);
    }

    @Override
    public int update(Supplier supplier) {
        return mapper.update(supplier);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

    @Override
    public List<Supplier> getSupplierListBySupId(Integer id) {
        return mapper.getSupplierListBySupId(id);
    }
}
