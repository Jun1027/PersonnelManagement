package jun.service.impl;

import com.github.pagehelper.PageHelper;
import jun.entity.TPosition;
import jun.dao.TPositionDao;
import jun.service.TPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TPosition)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
@Service("tPositionService")
public class TPositionServiceImpl implements TPositionService {
    @Resource
    private TPositionDao tPositionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public TPosition queryById(Integer pId) {
        return this.tPositionDao.queryById(pId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TPosition> queryAllByLimit(int offset, int limit) {
        return this.tPositionDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<TPosition> queryAll(int pageNum, int pageSize, TPosition tPosition) {
        PageHelper.startPage(pageNum,pageSize);
        return this.tPositionDao.queryAll(tPosition);
    }

    @Override
    public List<TPosition> queryAll(TPosition tPosition) {
        return this.tPositionDao.queryAll(tPosition);
    }

    @Override
    public int selectStaffNum(int[] ids) {
        return this.tPositionDao.selectStaffNum(ids);
    }

    /**
     * 新增数据
     *
     * @param tPosition 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(TPosition tPosition) {
        return this.tPositionDao.insert(tPosition);
    }

    /**
     * 修改数据
     *
     * @param tPosition 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TPosition tPosition) {
        return this.tPositionDao.update(tPosition);
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.tPositionDao.deleteById(pId) > 0;
    }

    @Override
    public int deleteBatch(int[] ids) {
        return this.tPositionDao.deleteBatch(ids);
    }
}