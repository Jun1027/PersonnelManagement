package jun.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TStaff)实体类
 *
 * @author makejava
 * @since 2020-05-14 18:31:11
 */
public class TStaff implements Serializable {
    private static final long serialVersionUID = -91386761304711037L;
    
    private Integer sId;
    
    private String sName;
    
    private String sSex;
    
    private String sPhonenumber;
    
    private String sEmal;
    
    private String sEducation;
    
    private String sIdno;
    
    private String sAddress;
    
    private Date sTime;
    
    private Integer sPid;
    
    private Integer sDid;


    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSSex() {
        return sSex;
    }

    public void setSSex(String sSex) {
        this.sSex = sSex;
    }

    public String getSPhonenumber() {
        return sPhonenumber;
    }

    public void setSPhonenumber(String sPhonenumber) {
        this.sPhonenumber = sPhonenumber;
    }

    public String getSEmal() {
        return sEmal;
    }

    public void setSEmal(String sEmal) {
        this.sEmal = sEmal;
    }

    public String getSEducation() {
        return sEducation;
    }

    public void setSEducation(String sEducation) {
        this.sEducation = sEducation;
    }

    public String getSIdno() {
        return sIdno;
    }

    public void setSIdno(String sIdno) {
        this.sIdno = sIdno;
    }

    public String getSAddress() {
        return sAddress;
    }

    public void setSAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public Date getSTime() {
        return sTime;
    }

    public void setSTime(Date sTime) {
        this.sTime = sTime;
    }

    public Integer getSPid() {
        return sPid;
    }

    public void setSPid(Integer sPid) {
        this.sPid = sPid;
    }

    public Integer getSDid() {
        return sDid;
    }

    public void setSDid(Integer sDid) {
        this.sDid = sDid;
    }

}