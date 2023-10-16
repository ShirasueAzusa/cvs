package cn.cvs.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
public class Supplier implements Serializable {
    private long id;
    private String supCode;
    private String supName;
    private String supDesc;
    private String supContact;
    private String supPhone;
    private String supAddress;
    private String supFax;
    private long createdUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedTime;
    private long updatedUserId;

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
