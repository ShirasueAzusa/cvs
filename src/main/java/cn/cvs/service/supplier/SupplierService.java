package cn.cvs.service.supplier;

import cn.cvs.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    int count();

    List<Supplier> getSupplierList(String supCode, String supName, String supContact, String createdTime);

    int insert(Supplier supplier);

    int update(Supplier supplier);

    int delete(int id);

    List<Supplier> getSupplierListBySupId(Integer id);
}
