package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysUser implements java.io.Serializable {
    private Integer id;             //ID
    private String account;         //账号
    private String realName;        //真实姓名
    private String password;        //用户密码
    private Integer sex;            //性别
    private Date birthday;          //出生日期
    private String phone;           //电话
    private String address;         //地址
    private Integer roleId;         //用户角色
    private Integer createdUserId;  //创建者
    private Date createdTime;       //创建时间
    private Integer updatedUserId;  //更新者
    private Date updatedTime;       //更新时间
    private Integer age;            //年龄
    private String roleIdName;      //角色名称
}
