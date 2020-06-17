package jun.controller;

import com.github.pagehelper.PageInfo;
import jun.entity.TPosition;
import jun.service.TPositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (TPosition)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
//@RestController
    @Controller
@RequestMapping("tPosition")
public class TPositionController {
    /**
     * 服务对象
     */
    @Resource
    private TPositionService tPositionService;

    @RequestMapping("queryAll")
    @RequiresPermissions("position:view")
    public String queryAll(TPosition tPosition, ModelMap modelMap, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        System.out.println(pageNum);
        PageInfo<TPosition> pageInfo = new PageInfo<>(tPositionService.queryAll(pageNum,pageSize,tPosition));
        modelMap.addAttribute("positionPageInfo",pageInfo);
        System.out.println(pageInfo);
        return "position_list";
    }

    @RequestMapping("addOne")
    @RequiresPermissions("position:add")
    public void addOne(TPosition tPosition, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        int result = tPositionService.insert(tPosition);
        try {
            if(result!=0){
                response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/position_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/position_add.jsp'</script>");
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
    @RequiresPermissions("position:modify")
    public String selectOne(Model model, Integer id) {
        TPosition tPosition = this.tPositionService.queryById(id);
        model.addAttribute("TPosition",tPosition);
        return "position_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tPosition
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TPosition tPosition) {
        response.setContentType("text/html;charset=utf-8");
        try {
            int result = tPositionService.update(tPosition);
            if(result!=0){
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tPosition/selectOne?id="+tPosition.getPId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tPosition/selectOne?id="+tPosition.getPId()+"'</script>");
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
    @RequiresPermissions("position:delete")
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
            if(tPositionService.selectStaffNum(arrnum)!=0){
                response.getWriter().print(3);
                return;
            }
            int number = arrnum.length;
            int result = tPositionService.deleteBatch(arrnum);
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