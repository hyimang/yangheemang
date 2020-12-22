<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>

  <!-- 대시보드 본문 Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- 본문헤더 Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">회원리스트</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">회원리스트</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- 본문내용 Main content -->
    <section class="content">
      <div class="container-fluid">
      
      <div class="row"><!-- 부트스트랩의 디자인 클래스 row -->
          <div class="col-12"><!-- 그리드시스템 중 12가로칼럼 중 12=100% -->
            <div class="card"><!-- 부트스트랩의 카드 클래스:네모난 디자인 -->
              <div class="card-header">
                <h3 class="card-title">회원 검색</h3>

                <div class="card-tools">
                  
                  <form name="search_form" action="/admin/member/member_list" method="get">
                  <div class="input-group input-group-sm">
                  <!-- 부트스트랩 템플릿만으로는 디자인처리 부족한 경우가 있기 때문에 위와 같은 인라인 스타일 사용 -->
                   <div>
                       <select name="search_type" class="form-control">
                           <option value="all" selected>-전체-</option>
                           <option value="user_id" data-select2-id="8">ID</option>
                           <option value="user_name" data-select2-id="17">이름</option>
                       </select>
                   </div>
                    <div>
                    <input type="text" name="search_keyword" class="form-control float-right" placeholder="Search">
					</div>
                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                  </form>
                  
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>user_id</th><!-- 테이블 헤드 타이틀태그 th -->
                      <th>user_name[point]</th>
                      <th>email</th>
                      <th>enabled</th>
                      <th>reg_date</th>
                      <th>levels</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:if test="${empty members}">
                  	<tr><td colspan="6" class="text-center">조회된 데이터가 없습니다.</td></tr>
                  </c:if>
                  <!-- jstl표준 core태그사용 반복문으로 Admin컨트롤러에서 가져온 members 오브젝트클래스 값을 출력 -->
                  <c:forEach items="${members}" var="member">
                  <tr>
                      <td><a href="/admin/member/member_view?page=${pageVO.page}&user_id=${member.user_id}">${member.user_id}</a></td>
                      <!-- 위에 a링크값은 리스트가 늘어날 수록 동적으로 user_id값이 변하게 됩니다. jsp로 처리 -->
                      <td>${member.user_name}[${member.point}]</td>
                      <td>${member.email}</td>
                      <td>${member.enabled}</td>
                      <td>${member.reg_date}</td>
                      <td><span class="badge bg-danger">${member.levels}</span></td>
                      <!-- 권한표시는 부트스트랩 뱃지 클래스 사용 -->
                  </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
              </div>
              <!-- /.card-body -->
    
            <!-- /.card -->
            
            <!-- 버튼영역 시작 -->
              <div class="card-body text-center">
              <a href="/admin/member/member_write" class="btn btn-primary float-right">CREATE</a>
              <!-- 부트스트랩 디자인 버튼 클래스를 이용해서 a태그를 버튼 모양 만들기 -->
              <!-- btn클래스명이 버튼모양을 만들고, btn-primary클래스명은 버튼 색상을 변경한느 역할 -->
				</div>
              <!-- 버튼 영역 끝 -->
			  <!-- 페이징 처리 시작 -->
            	<div class="pagination justify-content-center m-0">
              	<ul class="pagination">
              	<c:if test="${pageVO.prev}">
	              	 <li class="paginate_button page-item previous" id="example2_previous">
	              	 <a href="/admin/member/member_list?page=${pageVO.startPage-1}&search_type=${pageVO.search_type}&search_keyword=${pageVO.search_keyword}" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Previous</a>
	              	 </li>
	              	 <!-- 위 이전 게시물 링크-->
              	 </c:if>
              	<!-- jstl for문이고, 향상된 for문이 아닌 고전for문으로 시작값, 종료값 var변수idx는 인덱스값이 저장되어 있음-->
              	<c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage}" var="idx">
              	<li class='paginate_button page-item <c:out value="${idx==pageVO.page?'active':''}" />'>
              	<a href="/admin/member/member_list?page=${idx}&search_type=${pageVO.search_type}&search_keyword=${pageVO.search_keyword}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">${idx}</a></li>
              	</c:forEach>
              	 
              	 <c:if test="${pageVO.next}">
	              	 <!-- 아래 다음게시물 링크 -->
	              	 <li class="paginate_button page-item next" id="example2_next">
	              	 <a href="/admin/member/member_list?page=${pageVO.endPage+1}&search_type=${pageVO.search_type}&search_keyword=${pageVO.search_keyword}" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
	              	 </li>
              	 </c:if>
              	</ul>
              	</div>
              	<!-- 페이징 처리 끝 -->
          </div>
        </div>
      
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<%@ include file="../include/footer.jsp" %>