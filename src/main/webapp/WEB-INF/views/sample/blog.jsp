<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/header.jsp" %>
<section class="blog-section"><!-- division디비전이라는 div 영역표시 태그 대신에 사용-->
<h1>Blog</h1>
<div class="container">
<ul>
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/cup.jpg" alt="블로그이미지1"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>2020년 브랜드 평판 1위 수여</h2>
	</div>
	</a>
	</li>
	<hr><!-- horizontal 수평선 태그 -->
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/award.jpg" alt="블로그이미지2"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>기업 프레젠테이션 우승</h2>
	</div>
	</a>
	</li>
	<hr><!-- 수평선 태그 -->
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/medals.jpg" alt="블로그이미지3"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>소비자 만족도 조사 1위 기업 선정</h2>
	</div>
	</a>
	</li>
	<hr>	
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/cup.jpg" alt="블로그이미지4"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>블로그 게시물 제목4</h2>
	</div>
	</a>
	</li>
	<hr><!-- horizontal 수평선 태그 -->
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/award.jpg" alt="블로그이미지5"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>블로그 게시물 제목5</h2>
	</div>
	</a>
	</li>
	<hr><!-- 수평선 태그 -->
	<li>
	<a href="javascript:;">
	<div class="preview"><img src="/resources/sample/img/medals.jpg" alt="블로그이미지6"></div>
	<div class="info2">
	<time datetime="2020-11-23">2020-11-23</time>
	<h2>블로그 게시물 제목6</h2>
	</div>
	</a>
	</li>
</ul>
</div>
</section>
<%@ include file="./include/footer.jsp" %>