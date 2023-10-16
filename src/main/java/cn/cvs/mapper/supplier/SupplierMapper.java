package cn.cvs.mapper.supplier;

import cn.cvs.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    /**
     * 查询所有供应商
     *
     * @return
     */
    List<Supplier> selectAll(@Param("pageBegin") Integer pageBegin, @Param("pageSize") Integer pageSize, @Param("supCode") String supCode, @Param("supName") String supName);

    /**
     * 查询记录数
     *
     * @param supCode
     * @param supName
     * @return
     */
    int selectCount(@Param("supCode") String supCode, @Param("supName") String supName);
}
