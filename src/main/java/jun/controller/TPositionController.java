package jun.controller;

import jun.entity.TPosition;
import jun.service.TPositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPosition)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
@RestController
@RequestMapping("tPosition")
public class TPositionController {
    /**
     * 服务对象
     */
    @Resource
    private TPositionService tPositionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TPosition selectOne(Integer id) {
        return this.tPositionService.queryById(id);
    }

}