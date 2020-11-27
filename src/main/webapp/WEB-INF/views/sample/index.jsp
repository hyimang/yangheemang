<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp:JavaSeverPage 자바서버용페이지 -->
<%--자바주석 시작
- jsp에서 자바프로그램을 사용할 때 쓰는 태그 <% %>
- PHP 사용할때 쓰는 태그 <? ?>
- @page :애노테이션-페이지지시자(필수) ,언어:java,콘텐츠타입:text/html
 자바주석 끝--%>

<!-- HomeController.java에서 index.jsp로 매칭시킨 결과가 나오는 페이지입니다.<br>
- HTML에서  /resources/sample/index.html로 접근<br>
- jsp에서 홈 컨트롤러자바를 거쳐서 index.jsp로 접근하는 이유는 보안 때문.<br>
- 은행, 관공서, 대학에서 사용(스프링을 배우는 목적)<br>
- php프로그램은 html처럼 파일에 바로 접근 가능(중소기업홈페이지에 사용)<br>
- 스프링프레임워크: 자바에서 웹프로그램 만드는데 특화된 라이브러리(프로그램묶음)을 구조화 시켜놓아서, 개발자가 편하게 만들어 놓은 것(현재 버전5.x, 우린 4.3.22버전 사용)<br>
- jsp: 스프링MVC프로젝트, MVC에서 View단에 해당하는 기술 부분<br>
- Model(데이터베이스) - View(jsp페이지) - Controller(컨트롤러java클래스)<br>
- org.edu.controller 패키지명: 자바클래스가 있는 폴더 경로<br>
- 패키지 사용 이유: 자바클래스를 기능별로 묶어놓기 위해서 명시적으로 만듦<br> -->

<!DOCTYPE html><!-- 현재 문서의 형태선언 -->
<html><!-- html문서는 태그열고~태그닫고 영역확인 중요 -->
<head><!-- 문서내용과는 관계없는 문서정보= 메타데이터(데이터의 데이터)가 존재 -->
<meta charset="UTF-8"><!-- 문서의 언어 인코딩 설정, 지금은 유니코드로 설정 -->
<!-- 반응형을 작동하기 위해서 사용하는 메타태그 뷰포트는 모니터,모바일,프린터-->
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scaleable=no">
<title>반응형 홈페이지</title><!-- 문서의 제목을 브라우저 상단왼쪽에 표시 -->
<!-- 외부 자바스크립트 불러오는 태그(아래) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/resources/sample/js/user.js"></script>
<!-- 외부 css파일 불러오는 태그(아래) -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- 위 부트스트랩 코어 -->
<link rel="stylesheet" href="/resources/sample/css/reset.css" type="text/css">
<link rel="stylesheet" href="/resources/sample/css/mobile.css" type="text/css">
<link rel="stylesheet" href="/resources/sample/css/tablet.css" type="text/css">
<link rel="stylesheet" href="/resources/sample/css/pc.css" type="text/css">
<!-- span 한뼘= 자리를 차리하지 않는 영역 -->
<!-- :콜론(속성:값, Key:Value), ;세미콜론(문장의 끝) -->
<style>
/*@미디어쿼리 사용-메타태그 viewport값 필수*/
/*pc용 스타일 시작*/
/*미디어쿼리: 미디어의 가로크기가 1132px 이상이면 스타일 적용*/
@media all and (min-width:1132px) {



/*pc용 스타일 끝*/
</style>
<script>
/* 자바스크립트 시작 */
$(document).ready(function(){
	$(".carousel").carousel({
		interval:1000,//이미지가 좌우로 움직이는 대기시간 지정. 1초, 파이폭스만 작동X
		pause:false
	});
});
/* 자바스크립트 끝 */
</script>
</head>
<body><!-- 문서내용이 들어가는 영역 -->
<div id="wrap"><!-- 랩핑시킨 영역 -->
<header class="header">
<!-- 상단 로고와 햄버거 메뉴영역 시작 -->
<h1 class="logo">
<a href="index.html">LOGO</a><!-- a태그는 페이지이동역할, href 속성값에 URL을 입력해서 이동 -->
</h1><!-- 헤드라인 글자를 표시 -->
<div class="menu-toggle-btn">
<span></span>
<span></span>
<span></span>
</div>

<!--html5 시만텍 웹 =의미가 있는 태그를 사용하게 해서 AI가 인식 가능, nav태그 -->
<nav class="gnb"><!-- gnb:글로벌 네비게이션= 전체영역메뉴 -->
<!-- 리스트를 모여주는 태그 ul(Unordered List), ol(Ordered List) -->
<ul>
<li><a href="index.html">HOME</a></li>
<li><a href="weare.html">WE ARE</a></li>
<li><a href="work.html">WORK</a></li>
<li><a href="blog.html">BLOG</a></li>
<li><a href="contact.html">CONTACT US</a></li>
</ul>
</nav>
<!-- 상단 로고와 햄버거 메뉴영역 끝 -->
</header>
<section><!-- division디비전이라는 div 영역표시 태그 대신에 사용-->
<!-- 본문 슬라이드 영역 시작 -->
<!-- 이미지를 불러오는 태그 img -->
<!-- 경로: 상대(./img/...)절대(/resources/sample/img/...) -->
<!-- 태그안쪽에 지정한 스타일=인라인스타일 -->
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/resources/sample/img/slide1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/sample/img/slide2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/resources/sample/img/slide3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<!-- 본문 슬라이드 영역 끝 -->
</section>
<footer class="footer">
<!-- 하단 로고 영역 시작 -->
<p>MINT ROCKET</p><!-- Paragraph 문장영역 태그 -->
<!-- 하단 로고 영역 끝 -->
</footer>
</div>
</body>
</html>