package jun.service.impl;

import com.github.pagehelper.PageHelper;
import jun.entity.TPermission;
import jun.entity.TUser;
import jun.dao.TUserDao;
import jun.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 11:04:05
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer uId) {
        return this.tUserDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAll(int pageNum,int pageSize,TUser tUser) {
        PageHelper.startPage(pageNum,pageSize);
        return this.tUserDao.queryAll(tUser);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(TUser tUser) {
        return this.tUserDao.insert(tUser);
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public int  update(TUser tUser) {
        return this.tUserDao.update(tUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.tUserDao.deleteById(uId) > 0;
    }

    @Override
    public int deleteBatch(int[] ids) {
        return this.tUserDao.deleteBatch(ids);
    }

    @Override
    public TUser login(String uAccount, String uPwd) {
        return this.tUserDao.login(uAccount,uPwd);
    }

    @Override
    public TUser selectByName(String uAccount) {
        return this.tUserDao.selectByName(uAccount);
    }

    @Override
    public int selectNewsNum(int[] ids) {
        return this.tUserDao.selectNewsNum(ids);
    }

    @Override
    public int selectDocumentNum(int[] ids) {
        return this.tUserDao.selectDocumentNum(ids);
    }

    @Override
    public int insertRole(String account, String name) {
        return this.tUserDao.insertRole(account,name);
    }

    @Override
    public int selectRoleId(String account) {
        return this.tUserDao.selectRoleId(account);
    }

    @Override
    public int insertUserRole(int uid, int rid) {
        return this.tUserDao.insertUserRole(uid,rid);
    }

    @Override
    public int deleteRole(int rid) {
        return this.tUserDao.deleteRole(rid);
    }

    @Override
    public int deleteUserRole(int rid) {
        return this.tUserDao.deleteUserRole(rid);
    }

    @Override
    public Set<String> selectRoleName(String uAccount) {
        return this.tUserDao.selectRoleName(uAccount);
    }

    @Override
    public List<TPermission> selectUserPermissions(String uAccount) {
        return this.tUserDao.selectUserPermissions(uAccount);
    }
}