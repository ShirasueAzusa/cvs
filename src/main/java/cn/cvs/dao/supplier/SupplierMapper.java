package cn.cvs.dao.supplier;

import cn.cvs.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    int count();

    List<Supplier> getSupplierList(@Param("supCode") String supCode, @Param("supName") String supName, @Param("supContact") String supContact, @Param("createdTime") String createdTime);

    int insert(Supplier supplier);

    int update(Supplier supplier);

    int delete(int id);

    List<Supplier> getSupplierListBySupId(Integer id);
}
