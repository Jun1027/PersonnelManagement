package jun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import jun.entity.TUser;
import jun.service.PowerModifyService;
import jun.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;

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

    @Resource
    private PowerModifyService powerModifyService;


    /**
     *
     * @param uAccount
     * @param uPwd
     * @param request
     * @param response
     */
    @RequestMapping("login")
    public void login(String uAccount, String uPwd, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        TUser tUser = tUserService.login(uAccount,uPwd);
        if(tUser!=null){
            request.getSession().setAttribute("user",tUser);
            try {
                response.getWriter().print("<script>location.href='/jsp/index.jsp'</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            response.getWriter().print("<script>alert('账号与密码不符，请重新登入！！！');location.href='/login.jsp'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("loginByName")
    public void loginByName(String uAccount, String uPwd, HttpServletRequest request,String remeberme, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        UsernamePasswordToken token = new UsernamePasswordToken(uAccount,uPwd);
        if(!StringUtils.isEmpty(remeberme)){
            token.setRememberMe(true);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            //从shiro的session中取出存入web的session中
            request.getSession().setAttribute("userPermissions",tUserService.selectUserPermissions(uAccount));
            System.out.println(tUserService.selectUserPermissions(uAccount).toString());
            request.getSession().setAttribute("user",subject.getSession().getAttribute("user"));
            response.getWriter().print("<script>location.href='/jsp/index.jsp'</script>");
        } catch (AuthenticationException | IOException e) {
            try {
                response.getWriter().print("<script>alert('登录失败，请重新登录！！！');location.href='/login.jsp'</script>");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }


    }

    @RequestMapping("queryAll")
    @RequiresPermissions("user:view")
    public String queryAll(Model model, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize, TUser tUser){
        PageInfo<TUser> pageInfo = new PageInfo<>(tUserService.queryAll(pageNum,pageSize,tUser));
        model.addAttribute("userPageInfo",pageInfo);
        return "user_list";
    }

    @RequestMapping("addOne")
    @RequiresPermissions("user:add")
    public void addOne(TUser tUser,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        System.out.println(tUser);
        int result = tUserService.insert(tUser);
        //由于一个用户一个角色，添加一个用户就要添加一个角色并把他们绑定在用户角色表中
        try {
            if(result!=0){
                tUser = tUserService.selectByName(tUser.getUAccount());
                System.out.println(tUser);
                tUserService.insertRole(tUser.getUAccount(),tUser.getUName());
                int rid = tUserService.selectRoleId(tUser.getUAccount());
                tUserService.insertUserRole(tUser.getUId(),rid);
            response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/user_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/user_add.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 批量删除
     * @param ids
     * @param response
     */
    @RequestMapping("deleteBatch")
    @RequiresPermissions("user:delete")
    @ResponseBody
    public void deletebatch(String ids,HttpServletResponse response){
        int arr[] = new int[5];
        int j = 0;
        String[] arr1 = ids.split("\"");
        //取出所选的数字
        for(int i = 1;i<arr1.length;i+=2){
            arr[j++] = Integer.parseInt(arr1[i]);
        }
        int arrnum[] = new int[j];
        for (j=0;j<arrnum.length;j++){
            arrnum[j] = arr[j];
            System.out.println(arrnum[j]);
        }
        try {
            //判断是否发布过公告
            if(tUserService.selectNewsNum(arrnum)!=0){
                response.getWriter().print(3);
                return;
            }
            //判断是否上传过文档
            if(tUserService.selectDocumentNum(arrnum)!=0){
                response.getWriter().print(4);
                return;
            }

            //清除该用户的角色及权限
            for(int i = 0;i < arrnum.length;i++){
                TUser tUser = tUserService.queryById(arrnum[i]);
                //查询角色id
                Integer rid = tUserService.selectRoleId(tUser.getUAccount());
                //清楚权限
                powerModifyService.removePermission(rid);
                //删除用户角色
                tUserService.deleteUserRole(rid);
                //删除角色
                tUserService.deleteRole(rid);
            }
            int number = arrnum.length;
            //批量删除用户
            int result = tUserService.deleteBatch(arrnum);
            if (number==result){
                response.getWriter().print(1);
            }else{
                response.getWriter().print(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 通过主键查询单条数据
     *
     * @param uId 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    @RequiresPermissions("user:modify")
    public String selectOne(Model model,Integer uId) {
        TUser tUser = this.tUserService.queryById(uId);
        model.addAttribute("TUser",tUser);
        return "user_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tUser
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TUser tUser) {
        response.setContentType("text/html;charset=utf-8");
        try {
            int result = tUserService.update(tUser);
            if(result!=0){
                System.out.println(tUser);
                System.out.println(tUser.getUId());
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tUser/selectOne?uId="+tUser.getUId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tUser/selectOne?uId="+tUser.getUId()+"'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量删除
     * @param uaccount
     */
    @RequestMapping("selectAccount")
    @ResponseBody
    public void selectAccount(String uaccount,HttpServletResponse response){
        try {
            if (tUserService.selectByName(uaccount)!=null){
                response.getWriter().print(1);
            }else{
                response.getWriter().print(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}