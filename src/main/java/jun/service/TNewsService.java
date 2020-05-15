package jun.service;

import jun.entity.TNews;
import java.util.List;

/**
 * (TNews)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
public interface TNewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    TNews queryById(Integer nId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TNews> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tNews 实例对象
     * @return 实例对象
     */
    TNews insert(TNews tNews);

    /**
     * 修改数据
     *
     * @param tNews 实例对象
     * @return 实例对象
     */
    TNews update(TNews tNews);

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer nId);

}