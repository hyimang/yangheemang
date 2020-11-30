<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/header.jsp" %>
<section class="weare-section"><!-- division디비전이라는 div 영역표시 태그 대신에 사용-->
<section class="weare-header">
<h1 class="section-title">We are</h1>
<p>
"휴먼 교육센터 디지털 컨버전스 과정입니다."<br><!-- break return =줄바꿈태그 -->
"그리고, 지금은 화면 설계 시간입니다."
</p>
</section>
<!-- 갤러리 게시판에서 가져오는 데이터 4개 반복영역 -->
<section class="weare-body float-clear">
<ul>
<li>
<a href="javascript:;"><!-- a링크 태그의 가상링크# 대신에 javascript:; 입니다. -->
<img src="/resources/sample/img/same.jpg" alt="갤러리 게시물1">
<h2>수평적인 조직 문화</h2>
<p>닉네임을 호칭으로 사용하여<br>자유로운 의사소통이 가능합니다.</p>
</a>
</li>
<li>
<a href="javascript:;">
<img src="/resources/sample/img/hands.jpg" alt="갤러리 게시물2">
<h2>갤러리 제목2</h2>
<p>갤러리 게시물2의 내용입니다. 여러분 환영합...</p>
</a>
</li>
<li>
<a href="javascript:;">
<img src="/resources/sample/img/puzzle.jpg" alt="갤러리 게시물3">
<h2>갤러리 제목3</h2>
<p>갤러리 게시물3의 내용입니다. 여러분 환영합...</p>
</a>
</li>
<li>
<a href="javascript:;">
<img src="/resources/sample/img/puzzle.jpg" alt="갤러리 게시물4">
<h2>갤러리 제목4</h2>
<p>갤러리 게시물4의 내용입니다. 여러분 환영합...</p>
</a>
</li>
</ul>
</section>

</section>
<%@ include file="./include/footer.jsp" %>