package jun.service.impl;

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

    /**
     * 新增数据
     *
     * @param tPosition 实例对象
     * @return 实例对象
     */
    @Override
    public TPosition insert(TPosition tPosition) {
        this.tPositionDao.insert(tPosition);
        return tPosition;
    }

    /**
     * 修改数据
     *
     * @param tPosition 实例对象
     * @return 实例对象
     */
    @Override
    public TPosition update(TPosition tPosition) {
        this.tPositionDao.update(tPosition);
        return this.queryById(tPosition.getPId());
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
}