package jun.service;

import jun.entity.TDept;
import java.util.List;

/**
 * (TDept)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
public interface TDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    TDept queryById(Integer dId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TDept> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tDept 实例对象
     * @return 实例对象
     */
    TDept insert(TDept tDept);

    /**
     * 修改数据
     *
     * @param tDept 实例对象
     * @return 实例对象
     */
    TDept update(TDept tDept);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dId);

}