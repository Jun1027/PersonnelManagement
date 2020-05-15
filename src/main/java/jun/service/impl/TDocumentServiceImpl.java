package jun.service.impl;

import jun.entity.TDocument;
import jun.dao.TDocumentDao;
import jun.service.TDocumentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDocument)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 11:32:44
 */
@Service("tDocumentService")
public class TDocumentServiceImpl implements TDocumentService {
    @Resource
    private TDocumentDao tDocumentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    @Override
    public TDocument queryById(Integer dId) {
        return this.tDocumentDao.queryById(dId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TDocument> queryAllByLimit(int offset, int limit) {
        return this.tDocumentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDocument 实例对象
     * @return 实例对象
     */
    @Override
    public TDocument insert(TDocument tDocument) {
        this.tDocumentDao.insert(tDocument);
        return tDocument;
    }

    /**
     * 修改数据
     *
     * @param tDocument 实例对象
     * @return 实例对象
     */
    @Override
    public TDocument update(TDocument tDocument) {
        this.tDocumentDao.update(tDocument);
        return this.queryById(tDocument.getDId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer dId) {
        return this.tDocumentDao.deleteById(dId) > 0;
    }
}