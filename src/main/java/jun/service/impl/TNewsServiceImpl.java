package jun.service.impl;

import com.github.pagehelper.PageHelper;
import jun.entity.TNews;
import jun.dao.TNewsDao;
import jun.service.TNewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TNews)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
@Service("tNewsService")
public class TNewsServiceImpl implements TNewsService {
    @Resource
    private TNewsDao tNewsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    @Override
    public TNews queryById(Integer nId) {
        return this.tNewsDao.queryById(nId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TNews> queryAllByLimit(int offset, int limit) {
        return this.tNewsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<TNews> queryAll(int pageNum,int pageSize,TNews tNews) {
        PageHelper.startPage(pageNum,pageSize);
        return this.tNewsDao.queryAll(tNews);
    }
    /**
     * 新增数据
     *
     * @param tNews 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(TNews tNews) {
        return this.tNewsDao.insert(tNews);
    }

    /**
     * 修改数据
     *
     * @param tNews 实例对象
     * @return 实例对象
     */
    @Override
    public int update(TNews tNews) {
        return this.tNewsDao.update(tNews);
    }

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer nId) {
        return this.tNewsDao.deleteById(nId) > 0;
    }

    @Override
    public int deleteBatch(int[] ids) {
        return this.tNewsDao.deleteBatch(ids);
    }
}