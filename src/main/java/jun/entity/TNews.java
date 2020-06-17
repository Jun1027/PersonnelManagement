package jun.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TNews)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
@Data
public class TNews implements Serializable {
    private static final long serialVersionUID = -45663106753009902L;
    
    private Integer nId;
    
    private String nTitle;
    
    private String nContent;
    
    private String nDesc;
    
    private Date nTime;
    
    private Integer nUid;

    private String uName;

    private TUser user;



}