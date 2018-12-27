<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>个人信息-学习 论坛</title>
<meta name="description"
	content="学习 论坛 Open source blogging platform 。" />
<meta name="keywords" content="学习 论坛,学习,学习中文">

<meta name="HandheldFriendly" content="True" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="img/favicon.ico">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/monokai_sublime.min.css">
<link href="css/magnific-popup.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="css/screen.css?v=7dddbe75bf" />

<link rel="canonical" href="#" />
<meta name="referrer" content="origin" />
<link rel="next" href="http://www.ghostchina.com/page/2/" />
<script type="text/javascript" src="js/ghost-url.min.js?v=7dddbe75bf"></script>

<script type="text/javascript">
	ghost.init({
		clientId : "ghost-frontend",
		clientSecret : "721352203d6a"
	});
</script>
<link rel="alternate" type="application/rss+xml" title="学习 论坛" href="#" />

</head>
<body class="home-template">

	<!-- start header -->
	<header class="main-header" style="background-image: url(#)">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<!-- start logo -->
					<a class="branding" href="#" title="学习论坛"><img alt="160x160"
																   src="img/logo1.png" class="img-responsive" /></a>
					<!-- end logo -->
					<h3 class="text">加入论坛，一起学习，交流思想，收获知识。</h3>
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<nav class="main-navigation">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="navbar-header">
					<span class="nav-toggle-button collapsed" data-toggle="collapse"
						data-target="#main-menu"> <span class="sr-only">Toggle
							navigation</span> <i class="fa fa-bars"></i>
					</span>
				</div>
				<div class="collapse navbar-collapse" id="main-menu">
					<ul class="menu">
						<li role="presentation"><a
							href="index.jsp">首页</a></li>
						<li role="presentation"><a href="indexServlet.do">论坛</a></li>
						<li role="presentation"><a href="posttext.jsp">发帖</a></li>
						<li role="presentation"><a href="textServlet.do">我的帖子</a></li>
						<li class="nav-current" role="presentation"><a href="userInfoServlet.do">用户</a></li>
						<li role="presentation"><a href="register.html">注册</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</nav>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
	<div class="container">
		<div class="row">

			<main class="col-md-8 main-content">


			<div class="widget">
				<h4 class="title">个人资料</h4>
				<div class="content community">
					<c:if test="${sessionScope.account!=null}">

						<h4>
							<table>
								<tr>
									<td>用户名:<br></td>
									<td>${sessionScope.account.account}<br></td>
									<td>邮箱:<br></td>
									<td>${sessionScope.account.email}<br></td>
								</tr>
								<tr>
									<td>性别:</td>
									<td><c:if test="${requestScope.jspuserinfo.sex=='m'}">
					 男
				</c:if> <c:if test="${requestScope.jspuserinfo.sex=='f'}">
					女	
				</c:if></td>
									<td>年龄:</td>
									<td>${requestScope.jspuserinfo.age}</td>
								</tr>
								<tr>
									<td>QQ:</td>
									<td>${requestScope.jspuserinfo.qq}</td>
									<td>手机号:</td>
									<td>${requestScope.jspuserinfo.phone}</td>
								</tr>
								<tr>
									<td>个人介绍:</td>
									<td>${requestScope.jspuserinfo.description}</td>
								</tr>
								<tr>
									<td>常用地址:</td>
									<td>${requestScope.jspuserinfo.location}</td>
								</tr>
							</table>
						</h4>
						<a href="userInfoServlet.do?md=edit" class="btn btn-default">编辑个人资料
						</a>
					</c:if>
					<c:if test="${sessionScope.account==null}">
						<br>
						<h3 style="color: red">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp对不起，您尚未登录，请登录后查看！</h3>
					</c:if>
				</div>
			</div>

			</main>

			<aside class="col-md-4 sidebar">

			<div class="widget">

				<c:if test="${sessionScope.account==null}">
					<h4 class="title">登录</h4>
					<div class="content community">
						<form class="form-horizontal" action="userServlet.do"
							method="post">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">User</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="account"
										id="inputEmail3" placeholder="User">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">PWD</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" name="pwd"
										id="inputPassword3" placeholder="Password">
								</div>
							</div>
							<input type="hidden" name="flag" value="login">
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label> <input type="checkbox"> Remember me
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default">Sign in</button>
									<!--  <button type="button" class="btn btn-default"onclick="window.location.href(success.html)">Register</button> -->
									<a href="register.html">
										<button type="button" class="btn btn-default"
											onclick="window.location.href('register.html')">Register</button>
									</a> <br> <span id="error"></span>
								</div>
							</div>
						</form>
					</div>
				</c:if>
				<c:if test="${sessionScope.account!=null}">
					<h4 class="title">用户</h4>
					<div class="content community">
						<h4>账号:${sessionScope.account.account}</h4>

						<h4>邮箱:${sessionScope.account.email}</h4>
						<a href="posttext.jsp" class="btn btn-default">发布主题 </a>
						<a href="logoutServlet.do" class="btn btn-default"
							onclick="return logOut()">退出登录 </a>

					</div>
				</c:if>

			</div>

			<!-- start widget -->
			<div class="widget">
				<h4 class="title">下载</h4>
				<div class="content download">
					<a href="img/Java Servlet.docx" class="btn btn-default btn-block"
						onclick="download()">Servlet Word文档</a>
				</div>
			</div>
			<!-- end widget -->  </aside>

		</div>
	</div>
	</section>

	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright &copy; <a href="#">学习 论坛</a></span> | <span><a
						href="http://www.miibeian.gov.cn/" target="_blank">京ICP备1100110号</a></span>
					| <span>京公网安备110110110110110</span>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i></a>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fitvids.min.js"></script>
	<script src="js/highlight.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/main.js?v=7dddbe75bf"></script>
	<script>
		$(function() {
			$('.post-content img')
					.each(
							function(item) {
								var src = $(this).attr('src');

								$(this)
										.wrap(
												'<a href="' + src + '" class="mfp-zoom" style="display:block;"></a>');
							});
		});
	</script>

	<script>
		window._bd_share_config = {
			"common" : {
				"bdSnsKey" : {},
				"bdText" : "",
				"bdMini" : "2",
				"bdMiniList" : false,
				"bdPic" : "",
				"bdStyle" : "0",
				"bdSize" : "24"
			},
			"share" : {}
		};
		with (document)
			0[(getElementsByTagName('head')[0] || body)
					.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
					+ ~(-new Date() / 36e5)];
	</script>

	<script>
		$(function() {
			var version = '0.7.4';
			var $download = $('.download > a').first();
			var html = $download.html().replace(/\d\.\d\.\d/, version);

			$download.html(html);
		});
	</script>
	<script type="text/javascript">
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3F6338835ad35c6d950a554fdedb598e48' type='text/javascript'%3E%3C/script%3E"));
	</script>

</body>
</html>
