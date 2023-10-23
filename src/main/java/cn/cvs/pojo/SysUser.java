package cn.cvs.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
public class SysUser {
    private Integer id;    //id
    @NotEmpty(message = "用户编码不能为空")
    private String account;   //账号
    @NotNull(message = "密码不能为空")
    @Length(min = 7, max = 19, message = "用户密码必须在7到19之间")
    private String password;   //密码
    @NotEmpty(message = "用户名称不能为空")
    private String realName;   //真实姓名
    private Integer roleId;    //角色名称
    private String phone;     //电话
    private String address;    //地址
    private Integer sex;      //性别
    @Past(message = "必须是一个过去的时间")
    private Date birthday;    //出生日期
    private Integer createdUserId;    //创建人id
    private Date createdTime;      //创建时间
    private Integer updatedUserId;   //修改人id
    private Date updatedTime;      //修改时间
    private Integer age;      //年龄
    private String roleIdName; //角色名称
    private String idPicPath;//用户证件照
    private String workPicPath;//工作证照片

    public Integer getAge() {
        Date date = new Date();
        return date.getYear() - birthday.getYear();
    }

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
                ", idPicPath='" + idPicPath + '\'' +
                ", workPicPath='" + workPicPath + '\'' +
                '}';
    }
}
