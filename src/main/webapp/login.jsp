<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/21 0021
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>人事管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
    <style type="text/css">
        body{
            margin:0px; background: url(img/back.jfif) no-repeat; background-size:100% 100%; background-attachment:fixed;
            /*background-image: url("/img/back.jpg");*/
            /*background-image: linear-gradient(45deg, #7A88FF, #7AFFAF);*/
            /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            /*background-attachment: fixed;*/
        }
        /*垂直居中，div上边界距离窗口上边的距离为窗口高度的50%，
        实际上此时div内容整体已经偏下，再把整个身子往上移动一半即可
        并针对不同浏览器进行兼容。
        */
        .col-center-block {
            position: absolute;
            top: 50%;
            -webkit-transform: translateY(-50%);
            -moz-transform: translateY(-50%);
            -ms-transform: translateY(-50%);
            -o-transform: translateY(-50%);
            transform: translateY(-50%);
        }
        .jumbotron{
            padding: 2rem 1rem;
            margin-bottom: 2rem;
            background-color: rgba(255,255,255,0.2);
            border-radius: 0.3rem;
        }
        /*在输入框右边添加图标*/
        .myinputimg1{
            background:url("icons/person-lines-fill.svg") no-repeat right;
            background-size: 32px 20px;
            background-color: white;
        }
        .myinputimg2{
            background:url("icons/lock-fill.svg") no-repeat right;
            background-size: 32px 20px;
            background-color: white;
        }
    </style>
</head>
<body>
<div class="row justify-content-center " style="margin-right: 800px">
    <!-- 居中的div，添加.col-center-block -->
    <div class="col-center-block col-sm-4 col-xs-4 jumbotron p-4">
        <h3 class="text-center pb-5 mb-5">人事管理系统</h3>
        <div>
            <form class="bs-example bs-example-form" action="<%=request.getContextPath()%>/tUser/loginByName ">
                <div class="input-group-lg">
                    <span class="input-group-addon"><span>登录账号：</span></span>
                    <input type="text" name="uAccount" class="form-control myinputimg1" placeholder="登录账号" required>
                </div>
                <br>
                <div class="input-group-lg">
                    <span class="input-group-addon "><span>登录密码：</span></span>
                    <input type="password" name="uPwd" class="form-control myinputimg2" placeholder="登录密码" required>
                </div>
                <br>
                <div class="pt-5 pb-3">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
