<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2020/04/25 0025
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>表单</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
</head>

<body style="margin-top:-24px; margin-left: 15px; margin-right: 15px">
<div class="row mt-4">
    <div class="col p-0">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-bars pr-1"></i>  当前位置：员工管理 > 添加员工
            </div>
            <div class="col bg-light">
                <div class="bg-light mb-4">
                    <div class="row">
                        <div class="col text-center text-primary pt-5">
                            <i class="fa fa-plus-square-o pb-2" style="font-size: 60px;"></i>
                            <h1>添加员工</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col mt-5">
                            <form action="<%=request.getContextPath()%>/tStaff/addOne" onSubmit="return checkStaff(this);" method="post" class="needs-validation" novalidate>
                                <div class="row">
                                    <div class="form-group col-4">
                                        <label for="validationDefault01">员工姓名</label>
                                        <input type="text" name="sName" class="form-control" id="validationDefault01" required>
                                        <div class="invalid-feedback">
                                            员工姓名不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputSex">性别</label>
                                        <select id="inputSex" name="sSex" class="form-control" required>
                                            <div class="invalid-feedback">
                                                性别不能为空
                                            </div>
                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>
                                            <option value="男" selected>男</option>
                                            <option value="女">女</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputEducation">学历</label>
                                        <select id="inputEducation" name="sEducation" class="form-control" required>
                                            <div class="invalid-feedback">
                                                学历不能为空
                                            </div>
                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>
                                                <option selected value="初中">初中</option>
                                                <option value="高中">高中</option>
                                                <option value="大专">大专</option>
                                                <option value="本科">本科</option>
                                                <option value="硕士">硕士</option>
                                                <option value="博士">博士</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="form-group col-4">
                                        <label for="inputIdCard">证件编号</label>
                                        <input type="text" <%--onblur="checkIdCard()"--%> name="sIdno" class="form-control" id="inputIdCard" required>
                                        <div class="invalid-feedback">
                                            证件编号不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputTel">联系电话</label>
                                        <input type="text" name="sPhonenumber" <%--onblur="checkTel()"--%> class="form-control" id="inputTel" required>
                                        <div class="invalid-feedback">
                                            联系电话不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputPoistion">职位</label>
                                        <select id="inputPoistion" name="sPid" class="form-control" value="" required>
                                            <div class="invalid-feedback">
                                                职位不能为空
                                            </div>
                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>
                                            <c:forEach items="${positions}" var="position" varStatus="staus">
                                                <option <c:if test="${staus.count==1}">selected</c:if> value="${position.PId}">${position.PName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="form-group col-4">
                                        <label for="inputAddress">联系地址</label>
                                        <input type="text" name="sAddress" class="form-control" id="inputAddress" required>
                                        <div class="invalid-feedback">
                                            联系地址不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputEmail">邮箱</label>
                                        <input type="text" <%--onblur="checkEmail()"--%> name="sEmail" class="form-control" id="inputEmail" required>
                                        <div class="invalid-feedback">
                                            邮箱不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col-4">
                                        <label for="inputDept">部门</label>
                                        <select id="inputDept" name="sDid" class="form-control" required>
                                            <div class="invalid-feedback">
                                                部门不能为空
                                            </div>
                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>
                                            <c:forEach items="${depts}" var="dept" varStatus="staus">
                                                <option <c:if test="${staus.count==1}">selected</c:if> value="${dept.DId}">${dept.DName}</option>
                                            </c:forEach>
                                        </select>
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


                                function checkStaff(form)
                                {
                                    if(!/^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/.test(form.inputIdCard.value)) {
                                        alert("证件号格式错误");
                                        document.getElementById("inputIdCard").value='';
                                        return false;
                                    }else if(!/^1[3456789]\d{9}$/.test(form.inputTel.value)){
                                        alert("手机号格式错误");
                                        document.getElementById("inputTel").value='';
                                        return false;
                                    }else if(!/^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/.test(form.inputEmail.value)){
                                        alert("邮箱格式错误");
                                        document.getElementById("inputEmail").value='';
                                        return false;
                                    }

                                }


                                //邮箱检测
                                function checkEmail(){
                                    //正则表达式
                                    var reg = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
                                    var obj = $("#inputEmail"); //要验证的对象
                                    if(!reg.test(obj.val())){ //正则验证不通过，格式不对
                                        alert("邮箱验证不通过！！！");
                                        obj.val("");
                                        return;
                                    }
                                }
                                //电话号检测
                                function checkTel(){
                                    //正则表达式
                                    var reg = /^1[3456789]\d{9}$/;
                                    var obj = $("#inputTel"); //要验证的对象
                                    if(!reg.test(obj.val())){ //正则验证不通过，格式不对
                                        alert("手机号验证不通过！！！");
                                        obj.val("");
                                        return;
                                    }
                                }
                                //身份证号检测
                                function checkIdCard(){
                                    //正则表达式
                                    var reg = /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
                                    var obj = $("#inputIdCard"); //要验证的对象
                                    if(!reg.test(obj.val())){ //正则验证不通过，格式不对
                                        alert("身份证号验证不通过！！！");
                                        obj.val("");
                                        return;
                                    }
                                }
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
