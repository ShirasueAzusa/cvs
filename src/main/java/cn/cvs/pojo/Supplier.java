package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Supplier implements java.io.Serializable {
    private Integer id;                             //主键id
    private String supCode;                         //供货商编号
    private String supName;                         //供货商名称
    private String supDesc;                         //供货商描述
    private String supContact;                      //供货商联系人
    private String supPhone;                        //联系电话
    private String supAddress;                      //供货商地址
    private String supFax;                          //传真
    private Integer createdUserId;                  //创建人id
    private Date createdTime;                       //创建时间
    private Date updatedTime;                       //修改时间
    private Integer updatedUserId;                  //修改人id
    private List<StorageRecord> storageRecordList;

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", supCode='" + supCode + '\'' +
                ", supName='" + supName + '\'' +
                ", supDesc='" + supDesc + '\'' +
                ", supContact='" + supContact + '\'' +
                ", supPhone='" + supPhone + '\'' +
                ", supAddress='" + supAddress + '\'' +
                ", supFax='" + supFax + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", updatedUserId=" + updatedUserId +
                ", storageRecordList=" + storageRecordList +
                '}';
    }
}
