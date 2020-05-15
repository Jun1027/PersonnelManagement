package jun.dao;

import jun.entity.TNews;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TNews)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
public interface TNewsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    TNews queryById(Integer nId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TNews> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tNews 实例对象
     * @return 对象列表
     */
    List<TNews> queryAll(TNews tNews);

    /**
     * 新增数据
     *
     * @param tNews 实例对象
     * @return 影响行数
     */
    int insert(TNews tNews);

    /**
     * 修改数据
     *
     * @param tNews 实例对象
     * @return 影响行数
     */
    int update(TNews tNews);

    /**
     * 通过主键删除数据
     *
     * @param nId 主键
     * @return 影响行数
     */
    int deleteById(Integer nId);

}