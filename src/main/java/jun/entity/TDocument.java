package jun.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDocument)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:43
 */
@Data
public class TDocument implements Serializable {
    private static final long serialVersionUID = -90914780411031845L;
    
    private Integer dId;
    
    private String dTitle;
    
    private String dSrc;
    
    private String dDesc;
    
    private Date dTime;
    
    private Integer dUid;

    private String uName;

    private TUser user;

    private String dSize;

    private String dSuffix;

}