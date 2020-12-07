<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/header.jsp" %>
<section class="weare-section"><!-- division디비전이라는 div 영역표시 태그 대신에 사용-->
<section class="weare-header">
<h1 class="section-title">We are</h1>
<p>
"안녕하세요 민트로켓입니다."<br><!-- break return =줄바꿈태그 -->
"우리는 새로운 가치를 창조하는 기업입니다."
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
<img src="/resources/sample/img/same2.jpg" alt="갤러리 게시물2">
<h2>탄력적인 업무시간</h2>
<p>자신에게 맞는 시간에 근무하여 보다 효율적인 업무가 가능합니다.</p>
</a>
</li>
<li>
<a href="javascript:;">
<img src="/resources/sample/img/same3.jpg" alt="갤러리 게시물3">
<h2>전 직원 스톡옵션 제공</h2>
<p>직원과 회사가 같이 성장하고 미래를 함께 합니다.</p>
</a>
</li>
<li>
<a href="javascript:;">
<img src="/resources/sample/img/same4.jpg" alt="갤러리 게시물4">
<h2>사내 동호회 지원</h2>
<p>동호회 지원비를 지급해 보다 즐겁게 활동할 수 있습니다.</p>
</a>
</li>
</ul>
</section>

</section>
<%@ include file="./include/footer.jsp" %>