<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/05/18 0018
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <title>管理员信息</title>
</head>
<%--获取项目名--%>
<%
    String path = request.getContextPath();
%>
<body style="margin-top:-24px; margin-left: 15px; margin-right: 15px">
    <div class="row mt-4">
        <div class="col p-0">
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-bars pr-1"></i>  当前位置：后台管理 > 当前用户
                </div>
                <c:if test="${!empty userPermissions}">
                    <div class="row">
                        <div class="col ml-5 mt-3">
                            ${user.UName}你好，欢迎进入人事管理系统，你所拥有的权限如下：
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <c:forEach items="${userPermissions}" var="permission" varStatus="statu">
                            <div class="col-4 mb-2 text-center text-secondary">
                                    ${permission.PRemark}
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${empty userPermissions}">
                    <div class="row">
                        <div class="col ml-5 mb-3 mt-3">
                                ${user.UName}你好，欢迎进入人事管理系统，你对本系统无任何操作权限！！！
                        </div>
                    </div>
                </c:if>

            </div>
        </div>

    </div>
</body>
</html>
