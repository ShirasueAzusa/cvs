package cn.cvs.service;


import cn.cvs.pojo.Supplier;

import java.util.List;

public interface SupplierService {
    /**
     * 查询供货商记录
     */
    List<Supplier> selectAll(int pageNo, int pageSize, String supCode, String supName);

    /**
     * 根据编码和名称查询记录数
     */
    int selectCount(String supCode, String supName);

    /**
     * 添加
     */
    int insert(Supplier supplier);

    /**
     * 查询单个
     */
    Supplier selectOne(Integer id);

    /**
     * 修改供货商信息
     */
    int update(Supplier supplier);
}
