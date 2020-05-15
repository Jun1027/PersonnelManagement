<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="app-ui">
	<head>
		<!-- Meta -->
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
		<!-- Document title -->
		<title>人事管理系统</title>
		<!-- Favicons -->
		<link rel="icon" href="<%=request.getContextPath()%>/assets/img/favicons/favicon.ico" />
		<!-- Google fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,400italic,500,900%7CRoboto+Slab:300,400%7CRoboto+Mono:400" />
		<!-- Page JS Plugins CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/plugins/slick/slick.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/plugins/slick/slick-theme.min.css" />
		<!-- AppUI CSS stylesheets -->
		<link rel="stylesheet" id="css-font-awesome" href="<%=request.getContextPath()%>/assets/css/font-awesome.css" />
		<link rel="stylesheet" id="css-ionicons" href="<%=request.getContextPath()%>/assets/css/ionicons.css" />
		<link rel="stylesheet" id="css-bootstrap" href="<%=request.getContextPath()%>/assets/css/bootstrap.css" />
		<link rel="stylesheet" id="css-app" href="<%=request.getContextPath()%>/assets/css/app.css" />
		<link rel="stylesheet" id="css-app-custom" href="<%=request.getContextPath()%>/assets/css/app-custom.css" />
		<!-- End Stylesheets -->
	</head>

	<body class="app-ui layout-has-drawer layout-has-fixed-header">
		<div class="app-layout-canvas">
			<div class="app-layout-container">

				<!-- Drawer -->
				<aside class="app-layout-drawer">

					<!-- Drawer scroll area -->
					<div class="app-layout-drawer-scroll">
						<!-- Drawer logo -->
						<div id="logo" class="drawer-header">
							<a href="index.html"><img class="img-responsive" src="<%=request.getContextPath()%>/assets/img/logo/logo-backend.png" title="AppUI" alt="AppUI" /></a>
						</div>

						<!-- Drawer navigation -->
						<nav class="drawer-main">
							<ul class="nav nav-drawer">

								<!-- <li class="nav-item nav-drawer-header">用户管理</li>

                                <li class="nav-item active">
                                    <a href="index.html"><i class="ion-ios-speedometer-outline"></i> 查询用户</a>
                                </li>

                                <li class="nav-item">
                                    <a href="frontend_home.html"><i class="ion-ios-monitor-outline"></i> 新增用户</a>
                                </li> -->

								<li class="nav-item nav-drawer-header">后台管理</li>

								<li class="nav-item nav-item-has-subnav">
									<a href="javascript:void(0)"><i class="ion-ios-calculator-outline"></i> 用户管理</a>
									<ul class="nav nav-subnav">
										<li>
											<a href="">查询用户</a>
										</li>
										<li>
											<a href="">新增用户</a>
										</li>
									</ul>
								</li>

								<li class="nav-item nav-item-has-subnav">
									<a href="javascript:void(0)"><i class="ion-ios-compose-outline"></i> 部门管理</a>
									<ul class="nav nav-subnav">
										<li>
											<a href="">查询部门</a>
										</li>
										<li>
											<a href="">新增部门</a>
										</li>
									</ul>
								</li>

								<li class="nav-item nav-item-has-subnav">
									<a href="javascript:void(0)"><i class="ion-ios-list-outline"></i> 职位管理</a>
									<ul class="nav nav-subnav">
										<li>
											<a href="">查询职位</a>
										</li>
										<li>
											<a href="">新增职位</a>
										</li>
									</ul>
								</li>
							</ul>
						</nav>
						<!-- End drawer navigation -->

					</div>
					<!-- End drawer scroll area -->
				</aside>
				<!-- End drawer -->

				<!-- Header -->
				<header class="app-layout-header">
					<nav class="navbar navbar-default">
						<div class="container-fluid">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar-collapse"
								 aria-expanded="false">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<button class="pull-left hidden-lg hidden-md navbar-toggle" type="button" data-toggle="layout" data-action="sidebar_toggle">
									<span class="sr-only">Toggle drawer</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div>

							<div class="collapse navbar-collapse" id="header-navbar-collapse">

								<!-- .navbar-left -->

								<ul class="nav navbar-nav navbar-right navbar-toolbar hidden-sm hidden-xs">

									<li class="dropdown">
										<a href="javascript:void(0)" data-toggle="dropdown"><i class="ion-ios-bell"></i> <span class="badge">3</span></a>
										<ul class="dropdown-menu dropdown-menu-right">
											<li class="dropdown-header">Profile</li>
											<li>
												<a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">3</span> News </a>
											</li>
											<li>
												<a tabindex="-1" href="javascript:void(0)"><span class="badge pull-right">1</span> Messages </a>
											</li>
											<li class="divider"></li>
											<li class="dropdown-header">More</li>
											<li>
												<a tabindex="-1" href="javascript:void(0)">Edit Profile..</a>
											</li>
										</ul>
									</li>

									<li class="dropdown dropdown-profile">
										<a href="javascript:void(0)" data-toggle="dropdown">
											<span class="m-r-sm">张三 <span class="caret"></span></span>
											<img class="img-avatar img-avatar-48" src="<%=request.getContextPath()%>/assets/img/avatars/avatar3.jpg" alt="User profile pic" />
										</a>
										<ul class="dropdown-menu dropdown-menu-right">
											<li>
												<a href="">个人信息</a>
											</li>
											<li>
												<a href="">修改密码</a>
											</li>
											<li>
												<a href="">退出</a>
											</li>
										</ul>
									</li>
								</ul>
								<!-- .navbar-right -->
							</div>
						</div>
						<!-- .container-fluid -->
					</nav>
					<!-- .navbar-default -->
				</header>
				<!-- End header -->

				<main class="app-layout-content">

					<!-- Page Content -->
					<div class="container-fluid p-y-md">
						<!-- <div class="card">
							<div class="card-header">
								<h4>Inline Form</h4>
							</div>
							<div class="card-block card-block-full">
								<form class="form-inline" action="base_forms_elements.html" method="post" onsubmit="return false;">
									<div class="form-group">
										<label class="sr-only" for="example-if-email">Email</label>
										<input class="form-control" type="email" id="example-if-email" name="example-if-email" placeholder="Enter email..." />
									</div>
									<div class="form-group">
										<label class="sr-only" for="example-if-password" />Password</label>
										<input class="form-control" type="password" id="example-if-password" name="example-if-password" placeholder="Enter Password.." />
									</div>
									<div class="form-group m-b-0">
										<button class="btn btn-default" type="submit">Login</button>
									</div>
								</form>
							</div>
						</div> -->
						<!-- Dynamic Table Full -->
						<div class="card">
							<div class="card-header">
								<h4>数据表格</h4>
							</div>
							<div class="card-block">
								<!-- DataTables init on table by adding .js-dataTable-full class, functionality initialized in js/pages/base_tables_datatables.js -->
								<table class="table table-bordered table-striped table-vcenter ">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th>员工名称</th>
											<th class="hidden-xs">编号</th>
											<th class="hidden-xs w-20">地址</th>
											<th class="text-center" style="width: 10%;">操作</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${emplist}" var="emp" varStatus="i">
										<tr>
											<td class="text-center">${i.count}</td>
											<td class="font-500">${emp.name}</td>
											<td class="hidden-xs">${emp.cardid}</td>
											<td class="hidden-xs">${emp.address}</td>
											<td class="text-center">
												<div class="btn-group">
													<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Edit Client"><i class="ion-edit"></i></button>
													<button class="btn btn-xs btn-default" type="button" data-toggle="tooltip" title="Remove Client"><i class="ion-close"></i></button>
												</div>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- .card-block -->
						</div>
						<!-- .card -->
						<!-- End Dynamic Table Full -->
					</div>
					<!-- .container-fluid -->
					<!-- End Page Content -->

				</main>

			</div>
			<!-- .app-layout-container -->
		</div>
		<!-- .app-layout-canvas -->

		<!-- Apps Modal -->
		<!-- Opens from the button in the header -->

		<div class="app-ui-mask-modal"></div>

		<!-- AppUI Core JS: jQuery, Bootstrap, slimScroll, scrollLock and App.js -->
		<script src="<%=request.getContextPath()%>/assets/js/core/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/core/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/core/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/core/jquery.scrollLock.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/core/jquery.placeholder.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/app.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/app-custom.js"></script>

		<!-- Page JS Plugins -->
		<script src="<%=request.getContextPath()%>/assets/js/plugins/datatables/jquery.dataTables.min.js"></script>

		<!-- Page JS Code -->
		<script src="<%=request.getContextPath()%>/assets/js/pages/base_tables_datatables.js"></script>

	</body>

</html>
