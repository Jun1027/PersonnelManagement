package jun.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-05-15 11:04:05
 */
@Data
public class TUser implements Serializable {
    private static final long serialVersionUID = -85171416115983321L;
    
    private Integer uId;
    
    private String uName;
    
    private String uAccount;
    
    private String uPwd;
    
    private Date uTime;
    
    private Integer uSid;

    private String uSname;


}