package jun.controller;

import com.github.pagehelper.PageInfo;
import jun.entity.TDocument;
import jun.entity.TUser;
import jun.service.TDocumentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * (TDocument)表控制层
 *
 * @author makejava
 * @since 2020-05-15 11:32:44
 */
//@RestController
    @Controller
@RequestMapping("tDocument")
public class TDocumentController {
    /**
     * 服务对象
     */
    @Resource
    private TDocumentService tDocumentService;

    @RequestMapping("queryAll")
    @RequiresPermissions("document:view")
    public String queryAll(TDocument tDocument, ModelMap modelMap, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3") Integer pageSize){
        PageInfo<TDocument> pageInfo = new PageInfo<>(tDocumentService.queryAll(pageNum,pageSize,tDocument));
        modelMap.addAttribute("documentPageInfo",pageInfo);
        return "document_list";
    }

    /**
     * 上传
     * @param upfile
     * @param request
     * @param tDocument
     */
    @RequestMapping("upload")
    @RequiresPermissions("document:add")
    public void upload(MultipartFile upfile, HttpServletResponse response, HttpServletRequest request, TDocument tDocument){
        response.setContentType("text/html;charset=utf-8");
        try {
            //将文件上传到服务器的指定目录下
            String document = "document";
            String dir = request.getServletContext().getRealPath(document);
            String savefilename = UUID.randomUUID().toString();
            String filesuffix = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
            String savepath = dir+"/"+savefilename+filesuffix;
            String size = Long.toString(upfile.getSize()/1024)+"KB";
            upfile.transferTo(new File(savepath));

            //将文件信息保存到数据库
            TUser tUser = (TUser) request.getSession().getAttribute("user");
            tDocument.setDSrc(document+"/"+savefilename+filesuffix);
            tDocument.setDUid(tUser.getUId());
            tDocument.setDSize(size);
            tDocument.setDSuffix(filesuffix);
            int result = tDocumentService.insert(tDocument);
            if(result!=0){
                response.getWriter().print("<script>alert('添加成功！！！');location.href='/jsp/document_add.jsp'</script>");
            }else{
                response.getWriter().print("<script>alert('添加失败！！！');location.href='/jsp/document_add.jsp'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件下载
     * @param response
     * @param request
     * @param id
     */
    @RequestMapping("download")
    public void download(HttpServletResponse response,HttpServletRequest request,int id){
        response.setContentType("text/html;charset=utf-8");
        TDocument tDocument = tDocumentService.queryById(id);
//        System.out.println(tDocument);
        //获取文件输入流
        InputStream in = null;
        try {
            if(tDocument==null){
                response.getWriter().print(0);
            }
            response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(tDocument.getDTitle()+tDocument.getDSuffix(),"UTF-8"));
            String dir = request.getServletContext().getRealPath("");
            in = new FileInputStream(dir+"/"+tDocument.getDSrc());
            int len = 0;
            byte[] buffer = new byte[1024];
            OutputStream out = response.getOutputStream();
            while ((len = in.read(buffer))>0){
                out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器
            }
            in.close();
            out.close();
            response.getWriter().print(0);
            } catch (Exception e) {
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
    @RequiresPermissions("document:modify")
    public String selectOne(Model model, Integer id) {
        TDocument tDocument = this.tDocumentService.queryById(id);
        model.addAttribute("TDocument",tDocument);
        return "document_update";
    }
    /**
     * 通过主键查询单条数据
     *
     * @param tDocument
     * @return 单条数据
     */
    @RequestMapping("updateOne")
    public void updateOne(HttpServletResponse response, TDocument tDocument) {
        response.setContentType("text/html;charset=utf-8");
        try {
            int result = tDocumentService.update(tDocument);
            if(result!=0){
                response.getWriter().print("<script>alert('修改成功！！！');location.href='/tDocument/selectOne?id="+tDocument.getDId()+"'</script>");
            }else{
                response.getWriter().print("<script>alert('修改失败！！！');location.href='/tDocument/selectOne?id="+tDocument.getDId()+"'</script>");
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
    @RequiresPermissions("document:delete")
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
        int result = tDocumentService.deleteBatch(arrnum);
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