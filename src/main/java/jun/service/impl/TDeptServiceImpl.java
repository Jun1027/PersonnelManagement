package jun.service.impl;

import jun.entity.TDept;
import jun.dao.TDeptDao;
import jun.service.TDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDept)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
@Service("tDeptService")
public class TDeptServiceImpl implements TDeptService {
    @Resource
    private TDeptDao tDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    @Override
    public TDept queryById(Integer dId) {
        return this.tDeptDao.queryById(dId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TDept> queryAllByLimit(int offset, int limit) {
        return this.tDeptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDept 实例对象
     * @return 实例对象
     */
    @Override
    public TDept insert(TDept tDept) {
        this.tDeptDao.insert(tDept);
        return tDept;
    }

    /**
     * 修改数据
     *
     * @param tDept 实例对象
     * @return 实例对象
     */
    @Override
    public TDept update(TDept tDept) {
        this.tDeptDao.update(tDept);
        return this.queryById(tDept.getDId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer dId) {
        return this.tDeptDao.deleteById(dId) > 0;
    }
}