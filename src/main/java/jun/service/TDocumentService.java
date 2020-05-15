package jun.service;

import jun.entity.TDocument;
import java.util.List;

/**
 * (TDocument)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:32:44
 */
public interface TDocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    TDocument queryById(Integer dId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TDocument> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tDocument 实例对象
     * @return 实例对象
     */
    TDocument insert(TDocument tDocument);

    /**
     * 修改数据
     *
     * @param tDocument 实例对象
     * @return 实例对象
     */
    TDocument update(TDocument tDocument);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dId);

}