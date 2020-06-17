package jun.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TStaff)实体类
 *
 * @author makejava
 * @since 2020-05-14 18:31:11
 */
@Data
public class TStaff implements Serializable {
    private static final long serialVersionUID = -91386761304711037L;
    
    private Integer sId;
    
    private String sName;
    
    private String sSex;
    
    private String sPhonenumber;
    
    private String sEmail;
    
    private String sEducation;
    
    private String sIdno;
    
    private String sAddress;
    
    private Date sTime;

    private Integer sPid;

    private Integer sDid;

    private String pName;

    private String dName;

    private TPosition Position;

    private TDept Dept;


}