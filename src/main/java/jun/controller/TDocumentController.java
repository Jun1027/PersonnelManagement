package jun.controller;

import jun.entity.TDocument;
import jun.service.TDocumentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TDocument)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:44
 */
@RestController
@RequestMapping("tDocument")
public class TDocumentController {
    /**
     * 服务对象
     */
    @Resource
    private TDocumentService tDocumentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TDocument selectOne(Integer id) {
        return this.tDocumentService.queryById(id);
    }

}