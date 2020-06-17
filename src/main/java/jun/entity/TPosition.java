package jun.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TPosition)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
@Data
public class TPosition implements Serializable {
    private static final long serialVersionUID = -39080905460122705L;
    
    private Integer pId;
    
    private String pName;
    
    private String pInfo;


}