<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/22 0022
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
    <title>公告列表</title>
    <style type="text/css">
        td{
            vertical-align: middle !important;
        }
        .border-bottom {
            border-bottom: 2px solid #dee2e6 !important;
        }
    </style>
</head>
<%--获取项目名--%>
<%
    String path = request.getContextPath();
%>
<c:if test="${empty newsPageInfo }">
    <script type="text/javascript">
        window.location.href="<%=path%>/tNews/queryAll";
    </script>
</c:if>
<body style="margin-top:-24px; margin-left: 15px; margin-right: 15px">
    <div class="row mt-4">
        <div class="col p-0">
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-bars pr-1"></i>  当前位置：公告管理 > 公告列表
                </div>
                <div class="col">

                    <form class="form-inline mb-3 mt-3" action="<%=path%>/tNews/queryAll" id="searchFrom" method="post">
                        <input type="hidden" value="1" name="pageNum">
                        <div class="form-group mx-sm-3">
                            <span>搜索：</span>
                            <input type="text" name="nTitle" value="${TNews.NTitle}" style="width: 280px;" class="form-control" id="inputPassword2" placeholder="公告标题">
                        </div>
                        <button type="submit" class="btn btn-outline-primary"><i class="fa fa-search pr-1"></i>搜索</button>
                        <button type="button" class="btn btn-outline-danger btndele ml-3"><i class="fa fa-trash-o pr-1"></i>删除</button>
                    </form>
                </div>
                <table class="table table-striped text-center mb-0">
                    <tbody>
                    <tr class="bg-white border-bottom">
                        <th><input type="checkbox" id="idTotal"onclick="selectAll()" style="zoom:170%;"/></th>
                        <th>公告标题</th>
                        <th>公告介绍</th>
                        <th>发布时间</th>
                        <th>发布人</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${newsPageInfo.list}" var="news" varStatus="status">
                    <tr>
                        <td><input type="checkbox" name="ids" value="${news.NId}" style="zoom:170%;"/></td>
                        <td>${news.NTitle}</td>
                        <td>${news.NDesc}</td>
                        <td><fmt:formatDate value="${news.NTime}"></fmt:formatDate></td>
                        <td>${news.UName}</td>
                        <td>
                            <div class="btn-group">
                                <label class="btn btn-outline-primary border-right-0">
                                    <a class="text-primary" href="<%=path%>/tNews/selectOne?id=${news.NId}"><i class="fa fa-pencil-square-o pr-1"></i>修改</a>
                                </label>
                                <label class="btn btn-outline-danger">
                                    <input style="display: none" value="${paymanage.pid}">
                                    <a class="text-danger" data-toggle="modal" data-target="#exampleModalCenter${status.count}"><i class="fa fa-search-plus pr-1"></i>查看</a>
                                </label>
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModalCenter${status.count}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalCenterTitle">${news.NTitle}</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                                ${news.NContent}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
                                        </div>
                                    </div>
                                </div>
                            </div>





                        </td>
                    </tr>
                    </c:forEach>


                    <c:if test="${empty newsPageInfo.list}">
                        <tr>
                            <td colspan="12">无数据！！！</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
                <script>
                    $(".btndele").click(function(){
                        var ids = $('[name="ids"]');
                        var arr = new Array();
                        var j = 0;
                        for(var i = 0;i<ids.length;i++){
                            if($(ids[i]).is(':checked')==true){
                                arr[j++] = $(ids[i]).val();
                            }
                        }
                        if(arr.length==0){
                            window.confirm("请选择数据删除！！！")
                        }else{
                            if(window.confirm("确认删除所选数据吗？？？")){
                                $.post("/tNews/deleteBatch",{ids:JSON.stringify(arr)},function(resulate){
                                    if(resulate==1){
                                        for(var i = 0;i<ids.length;i++){
                                            if($(ids[i]).is(':checked')==true){
                                                $(ids[i]).parent().parent().remove();
                                            }
                                        }
                                        alert("数据删除成功");
                                    }else{
                                        alert("抱歉你无相应权限,数据删除失败！！！");
                                    }
                                });
                            }
                        }
                    });
                </script>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link">共${newsPageInfo.total}条数据分${newsPageInfo.pages}页显示</a></li>
                    <%--防止在第一页的时候出现上一页--%>
                    <c:if test="${newsPageInfo.pageNum==1}">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${newsPageInfo.pageNum!=1}">
                        <li class="page-item">
                                <a class="page-link" href="javascript:void(0)" onclick="page(${newsPageInfo.pageNum-1})" aria-label="Next">

                            <span aria-hidden="true">&laquo;</span>
                        </a>
                        </li>
                    </c:if>
                    <c:if test="${newsPageInfo.pageNum!=1}">
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0)" onclick="page(${newsPageInfo.pageNum-1})">${newsPageInfo.pageNum-1}</a>
                        </li>
                    </c:if>
                    <li class="page-item">
                        <a class="page-link bg-primary text-white" href="javascript:void(0)" onclick="page(${newsPageInfo.pageNum})">${newsPageInfo.pageNum}</a>
                    </li>
                    <c:if test="${newsPageInfo.pageNum!=newsPageInfo.pages&&newsPageInfo.pages!=0}">
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0)" onclick="page(${newsPageInfo.pageNum+1})">${newsPageInfo.pageNum+1}</a>
                        </li>
                    </c:if>
                    <%--防止在最后一页的时候出现下一页--%>
                    <c:if test="${newsPageInfo.pageNum!=newsPageInfo.pages&&newsPageInfo.pages!=0}">
                        <li class="page-item">
                            <a class="page-link" href="javascript:void(0)" onclick="page(${newsPageInfo.pageNum+1})" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                        </li>
                    </c:if>
                    <c:if test="${newsPageInfo.pageNum==newsPageInfo.pages||newsPageInfo.pages==0}">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            <script>
                /*普通分页及查询分页的嵌套使用*/
                function page(pageNum){
                    $("[name=pageNum]").val(pageNum);
                    $("#searchFrom").submit();
                }
                /*全选与全不选*/
                function selectAll(){
                    // var ids = document.getElementsByName("ids");
                    var ids = $('[name="ids"]');
                    var i = 0;
                    if($("#idTotal").is(':checked')==false){
                        for(i = 0;i<ids.length;i++){
                            ids[i].checked=false;
                        }
                    }
                    if($("#idTotal").is(':checked')==true){
                        for(i = 0;i<ids.length;i++){
                            ids[i].checked=true;
                        }
                    }
                    for(i=0;i<ids.length;i++){
                        console.log(ids[i]);
                    }
                }
            </script>
        </div>
    </div>





</body>
</html>
