package jun.service;

import jun.entity.TPermission;
import jun.entity.TUser;

import java.util.List;

public interface PowerModifyService {
    /**
     * 通过账号查询用户
     * @param account
     * @return
     */
    Integer selectByAccount(String account);
    /**
     * 查询所有权限
     * @return
     */
    List<TPermission> selectPermissions();
    /**
     * 根据角色id查询用户拥有的权限
     * @return
     */
    List<Integer> selectMyselfPermission(int rid);
    /**
     * 清空该用户的权限
     * @return
     */
    int removePermission(int rid);

    /**
     * 添加权限
     * @return
     */
    int addPermission(int rid,int pid);
}
