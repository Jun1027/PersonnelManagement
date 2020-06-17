<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/25 0025
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>表单</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
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
                <i class="fa fa-bars pr-1"></i>  当前位置：后台管理 > 添加用户
            </div>
            <div class="col bg-light">
                <div class="bg-light mb-4">
                    <div class="row">
                        <div class="col text-center text-primary pt-5">
                            <i class="fa fa-plus-square-o pb-2" style="font-size: 60px;"></i>
                            <h1>添加用户</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col mt-5">
                            <script>
                                function checkUser(form)
                                {
                                    if(form.uPwd.value!=form.surepwd.value)
                                    {
                                        alert("密码不一致");
                                        document.getElementById("validationDefault06").value='';
                                        document.getElementById("validationDefault05").value='';
                                        return false;
                                    }

                                }

                            </script>
                            <form action="<%=path%>/tUser/addOne" method="post" class="needs-validation" onSubmit="return checkUser(this);" novalidate>
                                <div class="row">
                                    <div class="col">
                                        <label for="validationDefault01">用户名</label>
                                        <input type="text" name="uName" class="form-control" id="validationDefault01" required>
                                        <div class="invalid-feedback">
                                            用户名不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="col">
                                        <label for="inputAccount">登录账号</label>
                                        <input type="text" name="uAccount" class="form-control" id="inputAccount" required>
                                        <div class="invalid-feedback">
                                            登录账号不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="col">
                                        <label for="inputType">用户状态</label>
                                        <select id="inputType" name="uSid" class="form-control" required>
                                            <div class="invalid-feedback">
                                                用户状态不能为空
                                            </div>
                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>
                                            <option value="1" selected>正常</option>
                                            <option value="2">禁用</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col">
                                        <label for="validationDefault05">登录密码</label>
                                        <input type="password" name="uPwd" class="form-control" id="validationDefault05" required>
                                        <div class="invalid-feedback">
                                            登录密码不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="col">
                                        <label for="validationDefault06">确认密码</label>
                                        <input type="password" name="surepwd" class="form-control" id="validationDefault06" required>
                                        <div class="invalid-feedback">
                                            确认密码不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                </div>

                                <hr class="mt-4" />
                                <div class="row">
                                    <div class="col">
                                        <button type="submit" class="btn btn-primary btn-lg btn-block">Submit Application</button>
                                    </div>
                                </div>
                            </form>
                            <script>
                                // Example starter JavaScript for disabling form submissions if there are invalid fields
                                (function() {
                                    'use strict';
                                    window.addEventListener('load', function() {
                                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                        var forms = document.getElementsByClassName('needs-validation');
                                        // Loop over them and prevent submission
                                        var validation = Array.prototype.filter.call(forms, function(form) {
                                            form.addEventListener('submit', function(event) {
                                                if (form.checkValidity() === false) {
                                                    event.preventDefault();
                                                    event.stopPropagation();
                                                }
                                                form.classList.add('was-validated');
                                            }, false);
                                        });
                                    }, false);
                                })();

                                //判断有没有该账号
                                $("#inputAccount").blur(function () {
                                    var uaccount = $(this).val();
                                    $.post("/tUser/selectAccount",{uaccount:uaccount},function(resulate){
                                        if(resulate==1){
                                            alert("该账号已被占用！！！");
                                            $("#inputAccount").val('');
                                        }
                                    });
                                })
                            </script>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>
