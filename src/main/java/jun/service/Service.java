package jun.service;

import java.util.List;

public interface Service<T> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    T queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(int offset, int limit);
    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<T> queryAll(int pageNum,int pageSize,T tUser);

    /**
     * 新增数据
     *
     * @param t 实例对象
     * @return 实例对象
     */
    int insert(T t);

    /**
     * 修改数据
     *
     * @param t 实例对象
     * @return 实例对象
     */
    int update(T t);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatch(int[] ids);
}
