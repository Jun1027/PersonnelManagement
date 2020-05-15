package jun.dao;

import jun.entity.TPosition;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPosition)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
public interface TPositionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    TPosition queryById(Integer pId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TPosition> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tPosition 实例对象
     * @return 对象列表
     */
    List<TPosition> queryAll(TPosition tPosition);

    /**
     * 新增数据
     *
     * @param tPosition 实例对象
     * @return 影响行数
     */
    int insert(TPosition tPosition);

    /**
     * 修改数据
     *
     * @param tPosition 实例对象
     * @return 影响行数
     */
    int update(TPosition tPosition);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

}