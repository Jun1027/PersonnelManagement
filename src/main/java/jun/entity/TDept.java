package jun.entity;

import java.io.Serializable;

/**
 * (TDept)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
public class TDept implements Serializable {
    private static final long serialVersionUID = 942401141708021085L;
    
    private Integer dId;
    
    private String dName;
    
    private String dInfo;


    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getDInfo() {
        return dInfo;
    }

    public void setDInfo(String dInfo) {
        this.dInfo = dInfo;
    }

}