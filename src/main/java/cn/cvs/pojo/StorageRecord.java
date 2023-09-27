package cn.cvs.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class StorageRecord implements java.io.Serializable {
    private Integer id;             //主键ID
    private String srCode;          //入库记录编码
    private String goodsName;       //商品名称
    private String goodsDesc;       //商品描述
    private String goodsUnit;       //商品单位
    private BigDecimal goodsCount;  //入库数量
    private BigDecimal totalAmount; //入库商品总额
    private Integer payStatus;          //支付状态（1未支付，2已支付）
    private Integer createdUserId;  //创建人id
    private Date createdTime;       //创建时间
    private Integer updatedUserId;  //修改人id
    private Date updatedTime;       //修改时间
    private Integer supplierId;     //供货商ID
    private String supplierName;    //供货商名称
    private Supplier supplier;

    @Override
    public String toString() {
        return "StorageRecord [id=" + id + ", srCode=" + srCode + ", goodsName=" + goodsName + ", goodsDesc=" + goodsDesc + ", goodsUnit=" + goodsUnit
                + ", goodsCount=" + goodsCount + ", totalAmount=" + totalAmount + ", payStatus=" + payStatus
                + ", createdUserId=" + createdUserId + ", createdTime=" + createdTime + ", updatedUserId=" + updatedUserId
                + ", updatedTime=" + updatedTime + ", supplierId=" + supplierId + ", supplierName=" + supplierName + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrCode() {
        return srCode;
    }

    public void setSrCode(String srCode) {
        this.srCode = srCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public BigDecimal getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(BigDecimal goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
