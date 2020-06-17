<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/05/30 0030
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script src="<%=request.getContextPath()%>/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <link href="<%=request.getContextPath()%>/css/bootstrap-switch.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/bootstrap-switch.min.js"></script><%--
    <link href="https://cdn.bootcss.com/bootstrap-switch/4.0.0-alpha.1/css/bootstrap-switch.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-switch/4.0.0-alpha.1/js/bootstrap-switch.min.js"></script>--%>


   <title>权限修改</title>
</head>
<%
    String path = request.getContextPath();
%>
<body style="margin-top:-24px; margin-left: 15px; margin-right: 15px">
<div class="row mt-4">
    <div class="col p-0">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-bars pr-1"></i>  当前位置：权限管理 > 修改权限
            </div>
            <div class="col">
                <form class="form-inline mb-3 mt-3" action="<%=path%>/powerModify/selectByAccount" id="searchFrom" method="post">
                    <input type="hidden" value="1" name="pageNum">
                    <div class="form-group mx-sm-3">
                        <span>搜索：</span>
                        <input type="text" value="${account}" id="account" name="account" style="width: 280px;" class="form-control" placeholder="请输入账号">
                    </div>
                    <button type="submit" class="btn btn-outline-primary searchFrom"><i class="fa fa-search pr-1"></i>搜索</button>
                </form>


                <div <c:if test="${empty account}">hidden</c:if>>
                <hr>
                <form action="<%=path%>/powerModify/modify" method="post">
                    <input type="hidden" name="ids" value="0">
                    <%--角色id--%>
                    <input type="hidden" name="rid" value="${rid}">
                    <div class="row text-center mb-2">
                    <c:forEach items="${listTotal}" var="total" varStatus="statu">
                        <div class="col-4 mt-2 text-secondary">
                                ${total.PRemark}&nbsp;&nbsp;&nbsp;
                                    <input type="checkbox" value="${total.PId}" class="ids" name="ids"
                        <%--判断用户是否有该权限--%>
                        <c:forEach items="${listMyself}" var="myself" varStatus="statu">
                                <c:if test="${myself==total.PId}">checked</c:if>
                        </c:forEach>
                        >
                        </div>
                    </c:forEach>
                    </div>
                    <hr class="mt-4" />
                    <div class="row mb-4">
                        <div class="col">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Submit Application</button>
                        </div>
                    </div>
                </form>
                </div>

            </div>

        </div>
    </div>

</div>

<script>


    $("[class='ids']").bootstrapSwitch({    //初始化按钮
        onText:"ON",
        offText:"OFF",
        handleWidth:"25",//开关左右宽度
        labelWidth:"26",//开关中间宽度
        onColor:"success",
        offColor:"info",
        size:"mini",
        /*onSwitchChange:function(event,state){
            if(state==true){
                console.log("开启");
            }else{
                console.log("关闭");
            }
        }*/
    });
</script>

</body>
</html>
