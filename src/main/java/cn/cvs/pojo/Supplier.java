package cn.cvs.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Supplier implements Serializable {
    private long id;
    @NotEmpty(message = "供货商编码不能为空")
    private String supCode;
    @NotEmpty(message = "供货商名称不能为空")
    private String supName;
    private String supDesc;
    @NotEmpty(message = "联系人不能为空")
    private String supContact;
    @Length(max = 11, message = "长度需要为11位")
    private String supPhone;
    private String supAddress;
    private String supFax;
    private long createdUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime;
    private long updatedUserId;
    private String companyLicPicPath;
    private String orgCodePicPath;

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
                '}';
    }
}
