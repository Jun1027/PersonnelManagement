package jun.dao;

import jun.entity.TStaff;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TStaff)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-14 18:31:12
 */
public interface TStaffDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    TStaff queryById(Integer sId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStaff> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tStaff 实例对象
     * @return 对象列表
     */
    List<TStaff> queryAll(TStaff tStaff);

    /**
     * 新增数据
     *
     * @param tStaff 实例对象
     * @return 影响行数
     */
    int insert(TStaff tStaff);

    /**
     * 修改数据
     *
     * @param tStaff 实例对象
     * @return 影响行数
     */
    int update(TStaff tStaff);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(Integer sId);

}