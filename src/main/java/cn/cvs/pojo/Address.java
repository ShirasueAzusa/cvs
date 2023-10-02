package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Address implements java.io.Serializable {
    private Integer id;             //主键ID
    private String contact;         //联系人
    private String addressDesc;     //地址
    private String postCode;        //邮编
    private String tel;             //联系电话
    private Integer createdUserId;  //创建者
    private Date createdTime;       //创建时间
    private Integer updateUserId;   //更新者
    private Date updateTime;        //更新时间
    private Integer userId;         //用户ID

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                '}';
    }
}
