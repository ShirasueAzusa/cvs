package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysRole implements java.io.Serializable {
    private Integer id;             //ID
    private String code;            //角色编码
    private String roleName;        //角色名称
    private Integer createdUserId;  //创建者
    private Date createdTime;       //创建时间
    private Integer updateUserId;   //更新者
    private Date updateTime;        //更新时间

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
