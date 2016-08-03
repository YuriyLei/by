<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>软件工程学院</title>
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/img_loop.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<div id="root">		
		<div id="top">
			<div id="logo" class="fl">
				<a><img alt="" src="images/logo.png" ></a>
				<span class="rjgc">软件工程学院</span>
			</div>
			<div id="oprate" class="fl">
			
			</div>
			<div class="cf"></div>
		</div>
		
		<div id="navigation">
			<div class="nav_z fl">
				<ul id="navul" class="cl">
					<li class="">
						<a href="#">首页</a>
					</li>
					<li>
						<a href="#">学院概况</a>
						<ul>
							<li><a href="#">专业介绍</a></li>
							<li><a href="#">整体概括</a></li>
							<li><a href="#">组织架构</a></li>
							<li><a href="#">规章制度</a></li>
						</ul>
					</li>
					<li>
						<a href="#">学院动态</a>
						<ul>
							<li><a href="#">学院新闻</a></li>
							<li><a href="#">师生风采</a></li>
							<li><a href="#">科研动态</a></li>
							<li><a href="#">教学动态</a></li>
						</ul>
					</li>
					<li>
						<a href="#">本科教育</a>
						<ul>
							<li><a href="#">专业建设</a></li>
							<li><a href="#">课程建设</a></li>
							<li><a href="#">教学管理</a></li>
						</ul>
					</li>
					<li>
						<a href="#">研究生</a>
						<ul>
							<li><a href="#">研究生概况</a></li>
							<li><a href="#">培养方案</a></li>
							<li><a href="#">研究生管理</a></li>
						</ul>
					</li>
					<li>
						<a href="#">科研工作</a>
						<ul>
							<li><a href="#">科研概况</a></li>
							<li><a href="#">科研管理</a></li>
							<li><a href="#">学术交流</a></li>
							<li><a href="#">项目与成果</a></li>
						</ul>
					</li>
					<li>
						<a href="#">学生之家</a>
						<ul>
							<li><a href="#">学生活动</a></li>
							<li><a href="#">日常管理</a></li>
							<li><a href="#">评奖评优</a></li>
						</ul>
					</li>
					<li>
						<a href="#">通知公告</a>
						<ul>
							<li><a href="#">事务通知</a></li>
							<li><a href="#">公示</a></li>
						</ul>
					</li>
					<li>
						<a href="#">招生就业</a>
						<ul>
							<li><a href="#">招生信息</a></li>
							<li><a href="#">就业前景</a></li>
							<li><a href="#">就业情况</a></li>
						</ul>
					</li>
					<li>
						<a href="#">更多</a>
					
					</li>
					<!--可在此处直接添加导航-->
				</ul>
			</div><!--导航结束-->
			<div class="cf"></div>
		</div>
		
		
		<div id="img_loop"><!-- 图片轮播 -->
			<div id="img_b" class="img_b">
				<a id="prev" class="prev_btn qq" href="javascript:void(0)"></a>
				<a id="next" class="next_btn qq" href="javascript:void(0)"></a>
				<div class="box">
					<img onClick="location.href='http://www.baidu.com/'"  src="images/01.jpg">
					<img onClick="location.href='http://www.baidu.com/'"  style="display: none" src="images/02.jpg"> 
					<img onClick="location.href='http://www.baidu.com/'" style="display: none"  src="images/03.jpg">
					<img onClick="location.href='http://www.baidu.com/'" style="display: none"  src="images/04.jpg"> 
					<img onClick="location.href='http://www.baidu.com/'" style="display: none" src="images/05.jpg">	
				</div>
				<div id="controller" class="controller">	
					<a class="trigger img_current" href="javascript:void(0)">1</a>
					<a class="trigger" href="javascript:void(0)">2</a>
					<a class="trigger" href="javascript:void(0)">3</a>
					<a class="trigger" href="javascript:void(0)">4</a>
					<a class="trigger" href="javascript:void(0)">5</a>		
				</div>
			</div>
		</div><!-- 图片轮播结束 -->
		
		<!-- 新闻模块 -->
		<div id="news_area">
			<div id="college_news" class="fl">
				<div class="news_head">
					<div id="news_title" class="fl">学院新闻</div>
					<div id="news_more" class="fr"><a href="#">更多...</a></div>
				</div>
				<div class="news_body">
					
				</div>
			</div>
			<div id="notice" class="fl">
				<div class="news_head">
					<div id="news_title" class="fl">通知公告</div>
					<div id="news_more" class="fr"><a href="#">更多...</a></div>
				</div>
				<div class="news_body">
				</div>
			</div>
			<div id="stu_activity" class="fl">
				<div class="news_head">
					<div id="news_title" class="fl">学生活动</div>
					<div id="news_more" class="fr"><a href="#">更多...</a></div>
				</div>
				<div class="news_body">
					
				</div>
			</div>
			
			<div class="cf"></div>
		</div>
	</div>


</body>
<script type="text/javascript" src="js/index_top_ten.js"></script>
</html>