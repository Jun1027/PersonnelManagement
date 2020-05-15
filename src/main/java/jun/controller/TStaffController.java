package jun.controller;

import jun.entity.TStaff;
import jun.service.TStaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStaff)表控制层
 *
 * @author makejava
 * @since 2020-05-14 18:31:14
 */
@RestController
@RequestMapping("tStaff")
public class TStaffController {
    /**
     * 服务对象
     */
    @Resource
    private TStaffService tStaffService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TStaff selectOne(Integer id) {
        return this.tStaffService.queryById(id);
    }

}