<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<a href="/">LOGO</a><!-- a태그는 페이지이동역할, href 속성값에 URL을 입력해서 이동 -->
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
<li><a href="/sample">SampleHOME</a></li>
<li><a href="/sample/weare">WE ARE</a></li>
<li><a href="/sample/work">WORK</a></li>
<li><a href="/sample/blog">BLOG</a></li>
<li><a href="/sample/contact">CONTACT US</a></li>
<li><a href="/admin">HOME</a></li>
</ul>
</nav>

<!-- 상단 로고와 햄버거 메뉴영역 끝 -->
</header>
</div>