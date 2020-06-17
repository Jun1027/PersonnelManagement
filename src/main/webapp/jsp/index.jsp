<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/21 0021
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="/css/bootstrap.css">
        <link href="/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="/js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>
        <title>首页</title>
    </head>
    <%--<c:if test="${empty user }">
        <script type="text/javascript">
            alert("请先登入！！！");
            window.location.href="<%=path%>/login.jsp";
        </script>
    </c:if>--%>


    <c:if test="${empty depts && empty positions}">
        <script type="text/javascript">
            window.location.href="<%=request.getContextPath()%>/tStaff/deptsAndPositions";
        </script>
    </c:if>
    <body style="margin-right: 15px">
    <div class="row">
        <div class="col pr-0">
            <nav class="navbar navbar-expand-lg navbar-light bg-dark">
                <a class="navbar-brand text-white" href="#">人事管理系统</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="btn bg-danger text-white" href="/logout"><i class="fa fa-power-off pr-1"></i>退出登录</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <span class="mr-3 text-muted mr-5 pr-5">欢迎您：${user.UName}</span>
                    </form>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-2 pr-0" style="height: 1000px; background-color: rgba(0, 0, 0, 0.03);">
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu">
                    <span><img src="../icons/person-fill.svg" class="pr-2 pb-1">用户管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu" class="list-group list-group-flush collapse">
                    <a href="/jsp/user_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">用户查询</li>
                    </a>
                    <a href="/jsp/user_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">添加用户</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu1">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">员工管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu1" class="list-group list-group-flush collapse">
                    <a href="/jsp/staff_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">员工查询</li>
                    </a>
                    <a href="/jsp/staff_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">添加员工</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu2">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">部门管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu2" class="list-group list-group-flush collapse">
                    <a href="dept_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">部门查询</li>
                    </a>
                    <a href="dept_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1">添加部门</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu3">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">职位管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu3" class="list-group list-group-flush collapse">
                    <a href="position_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>职位查询</li>
                    </a>
                    <a href="position_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>添加职位</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu4">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">公告管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu4" class="list-group list-group-flush collapse">
                    <a href="news_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>查询公告</li>
                    </a>
                    <a href="news_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>添加公告</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu5">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">文档管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu5" class="list-group list-group-flush collapse">
                    <a href="document_list.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>查询文档</li>
                    </a>
                    <a href="document_add.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>上传文档</li>
                    </a>
                </ul>
            </div>
            <div class="card">
                <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu6">
                    <span><img src="../icons/pencil-square.svg" class="pr-2 pb-1">权限管理</span>
                    <img src="../icons/caret-right-fill.svg" >
                </div>
                <ul id="childmenu6" class="list-group list-group-flush collapse">
                    <a href="power_modify.jsp" target="myWindow">
                        <li class="list-group-item"><img src="../icons/info-circle.svg" class="pr-2 pb-1"></img>权限修改</li>
                    </a>
                </ul>
            </div>
            <script type="text/javascript">
                $('#childmenu').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu1').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu1').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu2').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu2').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu3').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu3').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu4').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu4').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu5').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu5').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
                $('#childmenu6').on('hide.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-right-fill.svg")
                })
                $('#childmenu6').on('show.bs.collapse', function () {
                    $(this).prev().children("img").attr("src","../icons/caret-down-fill.svg")
                })
            </script>
        </div>
        <div class="col-10 pt-3">
            <!--<h1 class="text-center">欢迎光临</h1>-->
            <iframe name="myWindow" height="100%" width="100%" scrolling="auto" src="/jsp/user_info.jsp" frameborder="0"></iframe>
        </div>
    </div>

    <!-- <div class="card" style="width: 18rem;">
      <div class="card-header d-flex justify-content-between" data-toggle="collapse" href="#childmenu">
        Featured
        <img src="icons/caret-right-fill.svg" >
      </div>
      <ul id="childmenu" class="list-group list-group-flush collapse">
        <li class="list-group-item">Cras justo odio</li>
        <li class="list-group-item">Dapibus ac facilisis in</li>
        <li class="list-group-item">Vestibulum at eros</li>
      </ul>
      <script type="text/javascript">
          $('#childmenu').on('hide.bs.collapse', function () {
            $(this).prev().children("img").attr("src","icons/caret-right-fill.svg")
          })
        $('#childmenu').on('show.bs.collapse', function () {
            $(this).prev().children("img").attr("src","icons/caret-down-fill.svg")
        })
      </script>
    </div> -->
    </body>
</html>
