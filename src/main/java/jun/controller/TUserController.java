package jun.controller;

import jun.entity.TUser;
import jun.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:04:05
 */
//@RestController
    @Controller
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;



    /**
     *
//     * @param uAccount
//     * @param uPwd
     * @return 用户信息
     */
    @GetMapping("login")
    public String login(ModelMap modelMap) {
//        modelMap.addAttribute() this.tUserService.login(uAccount,uPwd);
        return "sdf";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        return this.tUserService.queryById(id);
    }

}