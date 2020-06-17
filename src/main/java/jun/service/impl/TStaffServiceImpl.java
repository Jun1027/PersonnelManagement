package jun.service.impl;

import com.github.pagehelper.PageHelper;
import jun.entity.TStaff;
import jun.dao.TStaffDao;
import jun.service.TStaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TStaff)表服务实现类
 *
 * @author makejava
 * @since 2020-05-14 18:31:14
 */
@Service("tStaffService")
public class TStaffServiceImpl implements TStaffService {
    @Resource
    private TStaffDao tStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public TStaff queryById(Integer sId) {
        return this.tStaffDao.queryById(sId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TStaff> queryAllByLimit(int offset, int limit) {
        return this.tStaffDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TStaff> queryAll(int pageNum, int pageSize, TStaff tStaff) {
        PageHelper.startPage(pageNum,pageSize);
        return this.tStaffDao.queryAll(tStaff);
    }

    /**
     * 新增数据
     *
     * @param tStaff 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(TStaff tStaff) {
        return this.tStaffDao.insert(tStaff);

    }

    /**
     * 修改数据
     *
     * @param tStaff 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TStaff tStaff) {
        return this.tStaffDao.update(tStaff);
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sId) {
        return this.tStaffDao.deleteById(sId) > 0;
    }

    @Override
    public int deleteBatch(int[] ids) {
        return this.tStaffDao.deleteBatch(ids);
    }
}