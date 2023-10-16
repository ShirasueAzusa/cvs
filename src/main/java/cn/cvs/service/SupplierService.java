package cn.cvs.service;


import cn.cvs.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    /**
     * 查询供货商记录
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Supplier> selectAll(int pageNo, int pageSize, String supCode, String supName);

    /**
     * 根据编码和名称查询记录数
     *
     * @param supCode
     * @param supName
     * @return
     */
    int selectCount(String supCode, String supName);
}
