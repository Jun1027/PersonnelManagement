package jun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TDept)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
@Data
public class TDept implements Serializable {
    private static final long serialVersionUID = 942401141708021085L;
    
    private Integer dId;
    
    private String dName;
    
    private String dInfo;


}