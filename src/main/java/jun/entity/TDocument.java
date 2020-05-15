package jun.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDocument)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:43
 */
public class TDocument implements Serializable {
    private static final long serialVersionUID = -90914780411031845L;
    
    private Integer dId;
    
    private String dTitle;
    
    private String dSrc;
    
    private String dDesc;
    
    private Date dTime;
    
    private Integer dUid;


    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public String getDTitle() {
        return dTitle;
    }

    public void setDTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public String getDSrc() {
        return dSrc;
    }

    public void setDSrc(String dSrc) {
        this.dSrc = dSrc;
    }

    public String getDDesc() {
        return dDesc;
    }

    public void setDDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public Date getDTime() {
        return dTime;
    }

    public void setDTime(Date dTime) {
        this.dTime = dTime;
    }

    public Integer getDUid() {
        return dUid;
    }

    public void setDUid(Integer dUid) {
        this.dUid = dUid;
    }

}