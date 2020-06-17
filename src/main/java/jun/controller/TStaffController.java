package jun.controller;

import com.github.pagehelper.PageInfo;
import jun.entity.TDept;
import jun.entity.TPosition;
import jun.entity.TStaff;
import jun.service.TDeptService;
import jun.service.TPositionService;
import jun.service.TStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * (TStaff)表控制层
 *
 * @author makejava
 * @since 2020-05-14 18:31:14
 */
//@RestController
@Controller
@RequestMapping("tStaff")
public class TStaffController {
    /**
     * 服务对象
     */
    @Resource
    private TStaffService tStaffService;



    @RequestMapping("queryAll")
    @RequiresPermissions("staff:view")
    public String queryAll(TStaff tStaff, ModelMap modelMap, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        System.out.println(pageNum);
        PageInfo<TStaff> pageInfo = new PageInfo<>(tStaffService.queryAll(pageNum,pageSize,tStaff));
        modelMap.addAttribute("staffPageInfo",pageInfo);
        System.out.println(pageInfo);
        return "staff_list";
    }

    @RequestMapping("addOne")
    @RequiresPermissions("staff:add")
    public void addOne(TStaff tStaff, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        System.out.println(tStaff);
        int result = tStaffService.insert(tStaff);
        try {
            if(result!=0){
                response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/staff_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/staff_add.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    TDeptService tDeptService;
    @Autowired
    TPositionService tPositionService;

    @RequestMapping("deptsAndPositions")
    public String deptsAndPositions(HttpSession session){
        List<TDept> deptslist = (List<TDept>) session.getAttribute("depts");
        if(deptslist==null){
            deptslist = tDeptService.queryAll(new TDept());
            session.setAttribute("depts",deptslist);
        }
        List<TPosition> positionslist = (List<TPosition>) session.getAttribute("positions");
        if(positionslist==null){
            positionslist = tPositionService.queryAll(new TPosition());
            session.setAttribute("positions",positionslist);
        }
        return "redirect:/jsp/index.jsp";
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    @RequiresPermissions("staff:modify")
    public String selectOne(Model model, Integer id) {
        TStaff tStaff = this.tStaffService.queryById(id);
        model.addAttribute("TStaff",tStaff);
        return "staff_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tStaff
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TStaff tStaff) {
        response.setContentType("text/html;charset=utf-8");
        try {
            System.out.println(tStaff);
            int result = tStaffService.update(tStaff);
            if(result!=0){
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tStaff/selectOne?id="+tStaff.getSId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tStaff/selectOne?id="+tStaff.getSId()+"'</script>");
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
    @RequiresPermissions("staff:delete")
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
        int number = arrnum.length;
        int result = tStaffService.deleteBatch(arrnum);
        try {
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