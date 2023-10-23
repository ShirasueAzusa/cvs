package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class StorageRecord implements java.io.Serializable {
    private Integer id;             //主键ID
    private String srCode;          //入库记录编码
    private String goodsName;       //商品名称
    private String goodsDesc;       //商品描述
    private String goodsUnit;       //商品单位
    private BigDecimal goodsCount;  //入库数量
    private BigDecimal totalAmount; //入库商品总额
    private Integer payStatus;      //支付状态（1未支付，2已支付）
    private Integer createdUserId;  //创建人id
    private Date createdTime;       //创建时间
    private Integer updatedUserId;  //修改人id
    private Date updatedTime;       //修改时间
    private Integer supplierId;     //供货商ID
    private String supplierName;    //供货商名称
    private Supplier supplier;

    @Override
    public String toString() {
        return "StorageRecord{" +
                "id=" + id +
                ", srCode='" + srCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", goodsCount=" + goodsCount +
                ", totalAmount=" + totalAmount +
                ", payStatus=" + payStatus +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
