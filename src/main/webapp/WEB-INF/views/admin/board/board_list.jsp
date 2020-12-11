<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../include/header.jsp" %>

  <!-- 대시보드 본문 Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- 본문헤더 Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">게시판리스트</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">게시판리스트</li>
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
                <h3 class="card-title">게시물 검색</h3>

                <div class="card-tools">
                  
                  <form name="search_form" action="/admin/board/board_list" method="get">
                  <div class="input-group input-group-sm">
                  <!-- 부트스트랩 템플릿만으로는 디자인처리 부족한 경우가 있기 때문에 위와 같은 인라인 스타일 사용 -->
                   <div>
                       <select class="form-control">
                           <option value="" selected>-전체-</option>
                           <option value="title" data-select2-id="8">제목</option>
                           <option value="content" data-select2-id="17">내용</option>
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
                      <th>bno</th><!-- 테이블 헤드 타이틀태그 th -->
                      <th>title[reply_count]</th>
                      <th>writer</th>
                      <th>regdate</th>
                      <th>view_count</th>
                    </tr>
                  </thead>
                  <tbody>
                  <!-- jstl core를 갖다스느 이유는 향상된 for반복문을 사용하기 위해서 지정함 -->
                  <!-- jstl core를 prefix로 지정한 것을 갖다 쓰는것 -->
                  <c:forEach items="${board_list}" var="boardVO">
                  <tr>
                      <td>${boardVO.bno}</td>
                      <!-- 아래 a링크값은 리스트가 늘어날 수록 동적으로 bno값이 변하게 됩니다. jsp로 처리 -->
                      <td><a href="/admin/board/board_view.html?bno=${boardVO.bno}">
                      <!-- c:out 사용하는 이유, 메롱을 방지하기 위한 시큐어코딩처리 -->
                      <c:out value="${boardVO.title}"></c:out>[<c:out value="${boardVO.reply_count}"></c:out>]
                      </a></td>
                      <td><c:out value="${boardVO.writer}"></c:out></td>
                      <td><fmt:formatDate pattern="yyyy-mm-dd HH:mm" value="${boardVO.regdate}"/></td>
                      <td><span class="badge bg-danger">${boardVO.view_count}</span></td>
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
              <a href="/admin/board/board_write" class="btn btn-primary float-right">CREATE</a>
              <!-- 부트스트랩 디자인 버튼 클래스를 이용해서 a태그를 버튼 모양 만들기 -->
              <!-- btn클래스명이 버튼모양을 만들고, btn-primary클래스명은 버튼 색상을 변경한느 역할 -->
				</div>
              <!-- 버튼 영역 끝 -->
			  <!-- 페이징 처리 시작 -->
            	<div class="pagination justify-content-center m-0">
              	<ul class="pagination">
              	 <li class="paginate_button page-item previous disabled" id="example2_previous">
              	 <a href="#" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
              	 </li>
              	 <!-- 위 이전 게시물 링크-->
              	 <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">1</a></li>
              	 <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0" class="page-link">2</a></li>
              	 <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0" class="page-link">3</a></li>
              	 <!-- 아래 다음게시물 링크 -->
              	 <li class="paginate_button page-item next" id="example2_next">
              	 <a href="#" aria-controls="example2" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
              	 </li>
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