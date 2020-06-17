package jun.controller;

import com.github.pagehelper.PageInfo;
import jun.entity.TDept;
import jun.service.TDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (TDept)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
//@RestController
@Controller
@RequestMapping("tDept")
public class TDeptController {
    /**
     * 服务对象
     */
    @Resource
    private TDeptService tDeptService;

    @RequestMapping("queryAll")
    @RequiresPermissions("dept:view")
    public String queryAll(TDept tDept, ModelMap modelMap, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        System.out.println(pageNum);
        PageInfo<TDept> pageInfo = new PageInfo<>(tDeptService.queryAll(pageNum,pageSize,tDept));
        modelMap.addAttribute("deptPageInfo",pageInfo);
        System.out.println(pageInfo);
        return "dept_list";
    }

    @RequestMapping("addOne")
    @RequiresPermissions("dept:add")
    public void addOne(TDept tDept, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        int result = tDeptService.insert(tDept);
        try {
            if(result!=0){
                response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/dept_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/dept_add.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    @RequiresPermissions("dept:modify")
    public String selectOne(Model model, Integer id) {
        TDept tDept = this.tDeptService.queryById(id);
        model.addAttribute("TDept",tDept);
        return "dept_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tDept
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TDept tDept) {
        response.setContentType("text/html;charset=utf-8");
        try {
            int result = tDeptService.update(tDept);
            if(result!=0){
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tDept/selectOne?id="+tDept.getDId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tDept/selectOne?id="+tDept.getDId()+"'</script>");
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
    @RequiresPermissions("dept:delete")
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
            if(tDeptService.selectStaffNum(arrnum)!=0){
                response.getWriter().print(3);
                return;
            }
            int number = arrnum.length;
            int result = tDeptService.deleteBatch(arrnum);
            if (number==result){
                response.getWriter().print(1);
            }else{
                response.getWriter().print(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}