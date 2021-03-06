<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>注册成功-学习 论坛</title>
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
						<li role="presentation"><a href="index.jsp">首页</a></li>
						<li role="presentation"><a href="indexServlet.do">论坛</a></li>
						<li role="presentation"><a href="posttext.jsp">发帖</a></li>
						<li role="presentation"><a href="textServlet.do">我的帖子</a></li>
						<li role="presentation"><a href="userInfoServlet.do">用户</a></li>
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

			<main class="col-md-8 main-content"> <c:forEach
				items="${jspAllText}" var="invitation" varStatus="index">
				<article id=98 class="post">

				<div class="post-head">
					<h1 class="post-title">
						<a href="textServlet.do?md=read&pid=${invitation.id}">${invitation.title}</a>
					</h1>
					<div class="post-meta">
						<span class="author">作者：${invitation.account}</span>
					</div>
				</div>
				<div class="post-content">
					<p>${invitation.article}</p>
				</div>
				<div class="post-permalink">
					<a href="textServlet.do?md=read&pid=${invitation.id}"
						class="btn btn-default">阅读全文</a>
				</div>

				<footer class="post-footer clearfix">
				<div class="pull-left tag-list">
					<i class="fa fa-folder-open-o"></i> <b>发帖时间:</b>
					<time class="post-date">${invitation.time}</time>
				</div>
				<div class="pull-right share"></div>
				</footer> </article>
			</c:forEach> </main>

			<aside class="col-md-4 sidebar"> <!-- start widget --> <!-- end widget -->

			<!-- start tag cloud widget -->
			<div class="widget">
				<h4 class="title">注册</h4>
				<div class="content community">
					<h3>注册成功,欢迎访问......</h3>
					<a href="index.jsp" class="btn btn-default">点击登录 </a>
				</div>
			</div>
			<!-- end tag cloud widget --> <!-- start widget -->
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

			/*$('.post-content').magnificPopup({
			  delegate: 'a',
			  type: 'image'
			});*/
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
