package jun.service;

import jun.entity.TPermission;
import jun.entity.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * (TUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:04:05
 */
public interface TUserService extends Service<TUser>{



    /**
     * 登录
     *
     * @param uAccount
     * @param uPwd
     * @return 用户信息
     */
    TUser login(String uAccount,String uPwd);
    /**
     * 根据用户id查询是否发布过公告
     * @param ids
     * @return
     */
    /**
     * 通过账号查询
     * @param uAccount
     * @return
     */
    TUser selectByName(@Param("uAccount") String uAccount);

    int selectNewsNum(int[] ids);

    /**
     * 根据用户id查询是否上传过文档
     * @param ids
     * @return
     */
    int selectDocumentNum(int[] ids);

    //添加角色及绑定
    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insertRole(String account,String name);
    /**
     * 查询角色id
     *
     * @return 影响行数
     */
    int selectRoleId(String account);
    /**
     * 新增数据
     *
     * @return 影响行数
     */
    int insertUserRole(int uid,int rid);

    /**
     * 删除角色
     * @param rid
     * @return
     */
    int deleteRole(int rid);
    /**
     * 删除用户角色
     * @param rid
     * @return
     */
    int deleteUserRole(int rid);


    /**
     * 根据账号查询用户角色集合
     * @param uAccount
     * @return
     */
    Set<String> selectRoleName(String uAccount);

    /**
     * 查询用户所有权限
     * @return
     */
    List<TPermission> selectUserPermissions(String uAccount);

}