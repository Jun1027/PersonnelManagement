package jun.controller;

import com.github.pagehelper.PageInfo;
import jun.entity.TNews;
import jun.entity.TUser;
import jun.service.TNewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (TNews)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:34
 */
//@RestController
    @Controller
@RequestMapping("tNews")
public class TNewsController {
    /**
     * 服务对象
     */
    @Resource
    private TNewsService tNewsService;

    @RequestMapping("queryAll")
    @RequiresPermissions("news:view")
    public String queryAll(TNews tNews, ModelMap modelMap, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        PageInfo<TNews> pageInfo = new PageInfo<>(tNewsService.queryAll(pageNum,pageSize,tNews));
        modelMap.addAttribute("newsPageInfo",pageInfo);
        return "news_list";
    }

    @RequestMapping("addOne")
    @RequiresPermissions("news:add")
    public void addOne(TNews tNews, HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        TUser tUser = (TUser) request.getSession().getAttribute("user");
        tNews.setNUid(tUser.getUId());
        int result = tNewsService.insert(tNews);
        try {
            if(result!=0){
                response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/news_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/news_add.jsp'</script>");
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
    @RequiresPermissions("news:modify")
    public String selectOne(Model model, Integer id) {
        TNews tNews = this.tNewsService.queryById(id);
        model.addAttribute("TNews",tNews);
        return "news_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tNews
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TNews tNews) {
        response.setContentType("text/html;charset=utf-8");
        try {
            System.out.println(tNews);
            int result = tNewsService.update(tNews);
            if(result!=0){
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tNews/selectOne?id="+tNews.getNId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tNews/selectOne?id="+tNews.getNId()+"'</script>");
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
    @RequiresPermissions("news:delete")
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
        int result = tNewsService.deleteBatch(arrnum);
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