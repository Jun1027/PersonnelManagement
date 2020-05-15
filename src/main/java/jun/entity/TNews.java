package jun.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TNews)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
public class TNews implements Serializable {
    private static final long serialVersionUID = -45663106753009902L;
    
    private Integer nId;
    
    private String nTitle;
    
    private String nContent;
    
    private String nDesc;
    
    private Date nTime;
    
    private Integer nUid;


    public Integer getNId() {
        return nId;
    }

    public void setNId(Integer nId) {
        this.nId = nId;
    }

    public String getNTitle() {
        return nTitle;
    }

    public void setNTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getNContent() {
        return nContent;
    }

    public void setNContent(String nContent) {
        this.nContent = nContent;
    }

    public String getNDesc() {
        return nDesc;
    }

    public void setNDesc(String nDesc) {
        this.nDesc = nDesc;
    }

    public Date getNTime() {
        return nTime;
    }

    public void setNTime(Date nTime) {
        this.nTime = nTime;
    }

    public Integer getNUid() {
        return nUid;
    }

    public void setNUid(Integer nUid) {
        this.nUid = nUid;
    }

}