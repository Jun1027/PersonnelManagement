package jun.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:04:05
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = -85171416115983321L;
    
    private Integer uId;
    
    private String uName;
    
    private String uAccount;
    
    private String uPwd;
    
    private Date uTime;
    
    private Integer uSid;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUAccount() {
        return uAccount;
    }

    public void setUAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getUPwd() {
        return uPwd;
    }

    public void setUPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public Date getUTime() {
        return uTime;
    }

    public void setUTime(Date uTime) {
        this.uTime = uTime;
    }

    public Integer getUSid() {
        return uSid;
    }

    public void setUSid(Integer uSid) {
        this.uSid = uSid;
    }

}