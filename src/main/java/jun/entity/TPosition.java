package jun.entity;

import java.io.Serializable;

/**
 * (TPosition)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
public class TPosition implements Serializable {
    private static final long serialVersionUID = -39080905460122705L;
    
    private Integer pId;
    
    private String pName;
    
    private String pInfo;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPInfo() {
        return pInfo;
    }

    public void setPInfo(String pInfo) {
        this.pInfo = pInfo;
    }

}