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
    <title>上传文档</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="/jq/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
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
                <i class="fa fa-bars pr-1"></i>  当前位置：文档管理 > 上传文档
            </div>
            <div class="col bg-light">
                <div class="bg-light mb-4">
                    <div class="row">
                        <div class="col text-center text-primary pt-5">
                            <i class="fa fa-pencil-square-o pb-2" style="font-size: 60px;"></i>
                            <h1>修改文档</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col mt-5">
                            <form action="<%=request.getContextPath()%>/tDocument/updateOne" enctype="multipart/form-data" method="post" class="needs-validation" novalidate>
                                <div class="row">
                                    <div class="form-group col offset-2">
                                        <input value="${TDocument.DId}" name="dId" style="display: none;">
                                        <label for="validationDefault01">文档标题</label>
                                        <input type="text" value="${TDocument.DTitle}" name="dTitle" style="width: 80%;" class="form-control" id="validationDefault01">
                                        <div class="invalid-feedback">
                                            标题不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="form-group col offset-2">
                                        <label for="inputDesc">文档简介</label><br>
                                        <textarea id="inputDesc" name="dDesc" style="width:80%; height:200px;"></textarea>
                                        <div class="invalid-feedback">
                                            简介不能为空
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
                                $("#inputDesc").val('${TDocument.DDesc}');
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
