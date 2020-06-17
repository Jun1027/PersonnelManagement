<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/22 0022
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
        <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
        <title>员工列表</title>
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
    <c:if test="${empty staffPageInfo}">
        <script type="text/javascript">
            window.location.href="<%=path%>/tStaff/queryAll";
        </script>
    </c:if>
    <body style="margin-top:-24px; margin-left: 15px; margin-right: 15px">
        <div class="row mt-4">
            <div class="col p-0">
                <div class="card">
                    <div class="card-header">
                        <i class="fa fa-bars pr-1"></i>  当前位置：员工管理 > 员工列表
                    </div>
                    <div class="col">

                        <form class="form-inline mb-3 mt-3" action="<%=path%>/tStaff/queryAll" id="searchFrom" method="post">
                            <input type="hidden" value="1" name="pageNum">
                            <div class="form-group mx-sm-3">
                                <span>搜索：</span>
                                <input type="text" value="${TStaff.SName}" style="width: 200px;" name="sName" class="form-control" placeholder="员工姓名搜索">
                                <input type="text" value="${TStaff.SPhonenumber}" style="width: 200px;" name="sPhonenumber" class="form-control ml-3" placeholder="手机号搜索">
                                <input type="text" value="${TStaff.SIdno}" style="width: 200px;" name="sIdno" class="form-control ml-3" placeholder="身份证搜索">
                                <input type="text" value="${TStaff.SEmail}" style="width: 200px;" name="sEmail" class="form-control ml-3" placeholder="邮箱搜索">
                            </div>
                            <div class="form-group mx-sm-3 mt-3">
                                <span>搜索：</span>
                            <select name="sPid" style="width: 200px;" class="custom-select" required>
                                <option disabled selected>职位</option>
                                <c:forEach items="${positions}" var="position">
                                    <option <c:if test="${TStaff.SPid==position.PId}">selected</c:if> value="${position.PId}">${position.PName}</option>
                                </c:forEach>
                            </select>
                            <select name="sDid" style="width: 200px;" class="custom-select ml-3" required>
                                <option disabled selected>部门</option>
                                <c:forEach items="${depts}" var="dept">
                                    <option <c:if test="${TStaff.SDid==dept.DId}">selected</c:if> value="${dept.DId}">${dept.DName}</option>
                                </c:forEach>
                            </select>
                            <select name="sEducation" style="width: 200px;" class="custom-select ml-3" required>
                                <option disabled selected>学历</option>
                                <option <c:if test="${TStaff.SEducation=='初中'}">selected</c:if> value="初中">初中</option>
                                <option <c:if test="${TStaff.SEducation=='高中'}">selected</c:if> value="高中">高中</option>
                                <option <c:if test="${TStaff.SEducation=='大专'}">selected</c:if> value="大专">大专</option>
                                <option <c:if test="${TStaff.SEducation=='本科'}">selected</c:if> value="本科">本科</option>
                                <option <c:if test="${TStaff.SEducation=='硕士'}">selected</c:if> value="硕士">硕士</option>
                                <option <c:if test="${TStaff.SEducation=='博士'}">selected</c:if> value="博士">博士</option>
                            </select>
                            <select name="sSex" style="width: 200px;" class="custom-select ml-3 mr-3" required>
                                <option disabled selected>性别</option>
                                <option <c:if test="${TStaff.SSex=='男'}">selected</c:if> value="男">男</option>
                                <option <c:if test="${TStaff.SSex=='女'}">selected</c:if> value="女">女</option>
                            </select>
                            <button type="submit" class="btn btn-outline-primary"><i class="fa fa-search pr-1"></i>搜索</button>
                            <button type="button" class="btn btn-outline-danger btndele ml-3"><i class="fa fa-trash-o pr-1"></i>删除</button>
                            </div>
                        </form>
                    </div>
                    <table class="table table-striped text-center mb-0">
                        <tbody>
                        <tr class="bg-white border-bottom">
                            <th><input type="checkbox" id="idTotal"onclick="selectAll()" style="zoom:170%;"/></th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>手机号号</th>
                            <th>邮箱</th>
                            <th>职位</th>
                            <th>学历</th>
                            <th>证件编号</th>
                            <th>部门</th>
                            <th>联系地址</th>
                            <th>建档日期</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${staffPageInfo.list}" var="staff" varStatus="status">
                        <tr>
                            <td><input type="checkbox" name="ids" value="${staff.SId}" style="zoom:170%;"/></td>
                            <td>${staff.SName}</td>
                            <td>${staff.SSex}</td>
                            <td>${staff.SPhonenumber}</td>
                            <td>${staff.SEmail}</td>
                            <td>${staff.PName}</td>
                            <td>${staff.SEducation}</td>
                            <td>${staff.SIdno}</td>
                            <td>${staff.DName}</td>
                            <td>${staff.SAddress}</td>
                            <td><fmt:formatDate value="${staff.STime}"></fmt:formatDate></td>
                            <td>
                                <div class="btn-group">
                                    <label class="btn btn-outline-primary">
                                        <a class="text-primary" href="<%=path%>/tStaff/selectOne?id=${staff.SId}"><i class="fa fa-pencil-square-o pr-1"></i>修改</a>
                                    </label>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        <c:if test="${empty staffPageInfo.list}">
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
                                    $.post("/tStaff/deleteBatch",{ids:JSON.stringify(arr)},function(resulate){
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
                        <li class="page-item"><a class="page-link">共${staffPageInfo.total}条数据分${staffPageInfo.pages}页显示</a></li>
                        <%--防止在第一页的时候出现上一页--%>
                        <c:if test="${staffPageInfo.pageNum==1}">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${staffPageInfo.pageNum!=1}">
                            <li class="page-item">
                                    <%-- <a class="page-link" href="<%=path%>/tStaff/queryAll?pageNum=${userPageInfo.pageNum-1}" aria-label="Previous">
                                     --%>    <a class="page-link" href="javascript:void(0)" onclick="page(${staffPageInfo.pageNum-1})" aria-label="Next">

                                <span aria-hidden="true">&laquo;</span>
                            </a>
                            </li>
                        </c:if>
                        <c:if test="${staffPageInfo.pageNum!=1}">
                            <li class="page-item"><%--
                            <a class="page-link" href="<%=path%>/tStaff/queryAll?pageNum=${userPageInfo.pageNum-1}">${userPageInfo.pageNum-1}</a>--%>
                                <a class="page-link" href="javascript:void(0)" onclick="page(${staffPageInfo.pageNum-1})">${staffPageInfo.pageNum-1}</a>
                            </li>
                        </c:if>
                        <li class="page-item"><%--
                            <a class="page-link bg-primary text-white" href="<%=path%>/tStaff/queryAll?pageNum=${userPageInfo.pageNum}">${userPageInfo.pageNum}</a>--%>
                            <a class="page-link bg-primary text-white" href="javascript:void(0)" onclick="page(${staffPageInfo.pageNum})">${staffPageInfo.pageNum}</a>
                        </li>
                        <c:if test="${staffPageInfo.pageNum!=staffPageInfo.pages&&staffPageInfo.pages!=0}">
                            <li class="page-item"><%--
                            <a class="page-link" href="<%=path%>/tStaff/queryAll?pageNum=${userPageInfo.pageNum+1}">${userPageInfo.pageNum+1}</a>--%>
                                <a class="page-link" href="javascript:void(0)" onclick="page(${staffPageInfo.pageNum+1})">${staffPageInfo.pageNum+1}</a>
                            </li>
                        </c:if>
                        <%--防止在最后一页的时候出现下一页--%>
                        <c:if test="${staffPageInfo.pageNum!=staffPageInfo.pages&&staffPageInfo.pages!=0}">
                            <li class="page-item"><%--
                            <a class="page-link" href="<%=path%>/tStaff/queryAll?pageNum=${userPageInfo.pageNum+1}" aria-label="Next">
                            --%><a class="page-link" href="javascript:void(0)" onclick="page(${staffPageInfo.pageNum+1})" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                            </li>
                        </c:if>
                        <c:if test="${staffPageInfo.pageNum==staffPageInfo.pages||staffPageInfo.pages==0}">
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
