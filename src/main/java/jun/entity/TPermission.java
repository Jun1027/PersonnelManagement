package jun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TPermission)实体类
 *
 * @author makejava
 * @since 2020-05-30 15:08:00
 */
@Data
public class TPermission implements Serializable {
    private static final long serialVersionUID = 719788849902028369L;
    
    private Integer pId;
    
    private String pName;
    
    private String pRemark;

}