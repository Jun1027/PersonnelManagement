package jun.controller;

import jun.entity.TNews;
import jun.service.TNewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TNews)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
@RestController
@RequestMapping("tNews")
public class TNewsController {
    /**
     * 服务对象
     */
    @Resource
    private TNewsService tNewsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TNews selectOne(Integer id) {
        return this.tNewsService.queryById(id);
    }

}