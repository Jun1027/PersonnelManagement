package jun.controller;

import jun.entity.TDept;
import jun.service.TDeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TDept)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
@RestController
@RequestMapping("tDept")
public class TDeptController {
    /**
     * 服务对象
     */
    @Resource
    private TDeptService tDeptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TDept selectOne(Integer id) {
        return this.tDeptService.queryById(id);
    }

}