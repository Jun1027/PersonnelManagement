package jun.controller;


import jun.entity.TPermission;
import jun.entity.TUser;
import jun.service.PowerModifyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 权限控制层
 *
 * Create by Jun on 2020-05-30
 */
@Controller
@RequestMapping("powerModify")
public class PowerModify {

    /**
     * 服务对象
     */
    @Resource
    private PowerModifyService powerModifyService;

    @RequestMapping("selectByAccount")
    @RequiresPermissions("power:modify")
    public void selectByAccount(String account, HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("text/html;charset=utf-8");
        //查询角色id
        Integer rid = powerModifyService.selectByAccount(account);
        try {
            if(rid!=null){
                    request.getSession().setAttribute("account",account);
                    //查询拥有的权限id
                    List<Integer> listMyself = powerModifyService.selectMyselfPermission(rid);
                    //查询所有权限
                    List<TPermission> listTotal = powerModifyService.selectPermissions();
                    //将角色id传过去
                    request.getSession().setAttribute("rid",rid);
                    request.getSession().setAttribute("listMyself",listMyself);
                    request.getSession().setAttribute("listTotal",listTotal);
                    response.getWriter().print("<script>location.href='/jsp/power_modify.jsp'</script>");

            }else{
                    response.getWriter().print("<script>alert('请输入正确账号！！！');location.href='/jsp/power_modify.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("modify")
    public void modify(int[] ids,int rid, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        //清空权限
        powerModifyService.removePermission(rid);
        //添加权限
        for (int i = 1;i<ids.length;i++){
            powerModifyService.addPermission(rid,ids[i]);
        }
        //查询拥有的权限id
        List<Integer> listMyself = powerModifyService.selectMyselfPermission(rid);
        //存入session
        request.getSession().setAttribute("listMyself",listMyself);

        try {
            response.getWriter().print("<script>alert('权限修改成功！！！');location.href='/jsp/power_modify.jsp'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
