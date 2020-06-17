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
    <title>添加缴费信息</title>
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
<body style="margin-top:-24px; margin-left: 15px; margin-right: 15px;">
<div class="row mt-4">
    <div class="col p-0">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-bars pr-1"></i>  当前位置：公告管理 > 修改公告
            </div>
            <div class="col bg-light">
                <div class="bg-light mb-4">
                    <div class="row">
                        <div class="col text-center text-primary pt-5">
                            <i class="fa fa-pencil-square-o pb-2" style="font-size: 60px;"></i>
                            <h1>修改公告</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col mt-5">
                            <form action="<%=request.getContextPath()%>/tNews/updateOne" method="post" class="needs-validation" novalidate>
                                <div class="row">
                                    <div class="col">
                                        <input value="${TNews.NId}" name="nId" style="display: none;">
                                        <label for="validationDefault01">公告标题</label>
                                        <input type="text" value="${TNews.NTitle}" name="nTitle" class="form-control" id="validationDefault01">
                                        <div class="invalid-feedback">
                                            公告标题不能为空！！！
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group col">
                                        <label for="validationDefault02">公告简介</label>
                                        <input type="text" value="${TNews.NDesc}" name="nDesc" class="form-control" id="validationDefault02">
                                        <div class="invalid-feedback">
                                            公告简介不能为空
                                        </div>
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                </div>

                                <div class="row mt-3">

                                    <div class="form-group col">
                                        <label for="text1">公告内容</label>
                                        <div id="text">

                                        </div>
                                        <textarea id="text1" hidden name="nContent" style="width:100%; height:200px;"></textarea>
                                        <div class="invalid-feedback">
                                            开始时间不能为空
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
                            <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
                            <script type="text/javascript" src="/wangEditor/wangEditor.js"></script>
                            <script type="text/javascript">
                                var E = window.wangEditor
                                var editor = new E('#text')
                                var $text1 = $('#text1')
                                editor.customConfig.onchange = function (html) {
                                    // 监控变化，同步更新到 textarea
                                    $text1.val(html)
                                }
                                editor.create()
                                // 初始化 textarea 的值
                                $text1.val(editor.txt.html('${TNews.NContent}'))

                            </script>
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
