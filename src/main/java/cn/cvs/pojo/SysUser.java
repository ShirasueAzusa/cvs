package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class SysUser {
    private Integer id;    //id
    private String account;   //账号
    private String password;   //密码
    private String realName;   //真实姓名
    private Integer roleId;    //角色名称
    private String phone;     //电话
    private String address;    //地址
    private Integer sex;      //性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;    //出生日期
    private Integer createdUserId;    //创建人id
    private Date createdTime;      //创建时间
    private Integer updatedUserId;   //修改人id
    private Date updatedTime;      //修改时间
    private Integer age;      //年龄
    private String roleIdName; //角色名称

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", roleId=" + roleId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                ", age=" + age +
                ", roleIdName='" + roleIdName + '\'' +
                '}';
    }
}
