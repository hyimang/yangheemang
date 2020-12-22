package org.edu.vo;
/**
 * PageVO클래스로서 회원, 게시판 공통으로 사용.
 * 1페이지 당 보여줄 개수를 이용해서 전체데이터를 분할해서 보여주는 역할
 * 필요이유: 회원 또는 게시물이 10만건을 한꺼번에 보여주면, 조회속도가 느리게 됨
 * 1페이지당 10개 또는 20개, 30개 등등 제한을 두어서, 속도향상 및 사용자화면을 개선시킴
 * 아래 계산식에서 []부분이 멤버변수로 생성해야할 부분.
 * - 1페이지 계산 10(1페이지당 출력할 갯수)x(1[페이지번호]-1)=0 1페이지일때
 * - 2페이지 계산 10x(2-1)=10[계산결과 나온 시작페이지 번호] 2페이지일때
 * @author 양희망
 *
 */
public class PageVO {
	//예)변수 중 boolean(일반형데이터형변수)/boolean(대문자로 시작-클래스형 변수-Null로 입력되었을 때 처리하는 로직이 들어있음)
	private int perPageNum;//리스트 하단에 보이는 페이징번호의 갯수값이 들어가는 변수
	private int queryPerPageNum;//쿼리에서 사용하는 1페이지당 출력할 갯수값 변수 
	private Integer page;//jsp에서 선택한 페이지 번호값이 들어가는 변수
	private int queryStartNo;//쿼리에서 사용되는 시작인덱스값 변수
	private boolean prev;//[계산식]페이징에서 이전 번호가 있을 때 표시값이 들어가는 변수
	private boolean next;//[계산식]페이징에서 이후 번호가 있을때 표시값이 들어가는 변수
	//위에 생성한 프리뷰, 넥스트 변수값이 있는 지 없는 확인하려면 [계산식]이 필요합니다. 계산할 때 필요한 변수 3개가 필요(아래)
	private int totalCount;//회원[게시물] 전체의 갯수값이 들어가는 변수
	private int startPage;//jsp화면에서 보여주는 페이징 리스트의 시작번호
	private int endPage;//jsp화면에서 보여주는 페이징 리스트의 끝번호
	//start 페이지와 end페이지 변수가 필요한 이유
	
	//검색에 필요한 변수 2개도 포함시켜서, 컨트롤러에서 매개변수 사용을 축소하게 됨
	private String search_type;//검색 조건
	private String search_keyword;//검색어
	
	//전체 클래스에서 [계산식]이 4개필요. 만들어야함
	//계산식 4개로 반환되는 값은: startPage(11), endPage(20), prev(true), next(false)
	//아래 메서드를 
	private void calcPage() {
		//page 변수는 현재 jsp에서 클릭한 페이지번호를 받아서 예로 8을 받아서 아래 계산식에서 사용
		//(int)형변환: 2.1, 2.8 다 2로 반환이 됩니다.
		//ceil메서드: 천장값을 반환 1.1=>2,2.3=>3
		//floor메서드: 바닥값을 반환1.1=>1,2.3=>2
		//ceil(1/10)=>1.0 0.9 0.8 ... 0.0 -0.1 -0.2 =>1
		//ceil(11/10)*00=>20페이지
		int tempEnd = (int)(
				Math.ceil(page/(double)this.perPageNum)*this.perPageNum
				);
		//jsp 에서 클릭한 페이지번호 예로 1을 기준으로 끝 페이지를 계산한다(아래)
		//예) < 1 2 3 4 5 6 7 8 9 10(tempEnd) > 페이징 리스트 시작1과 끝10값이 바뀌게 됩니다.
		//예) < 11 12 13 14 15 16 17 18 19 20(tempEnd) >시작11 끝20
		this.startPage = (tempEnd -this.perPageNum) +1;
		//jsp에서 11을 클릭했을 떄 (20-10)+1=11스타트 페이지 값(위)
		//(아래) 20 x 10 =200개의 레코드(회원[게시물])
		//만약 회원[게시물]195개일 경우가 있음
		if(tempEnd*this.queryPerPageNum > this.totalCount) {//경우 200>195
			//(임시끝페이지x쿼리에서 1페이지당출력할 갯수 > 실제전체갯수)
			//클릭한 page 번호로 계산된 게시물 수가 실제 게시물(totalCount)수보다 클떄
			this.endPage = (int)Math.ceil(
					this.totalCount/(double)this.queryPerPageNum
					);// 195/10=>[20] 19.9 19.8 ... 19.5
			//195/10=>20 잘못된 경우
		} else {
			// 전체회언[게시물]수가 195일때 page 1을 클릭한 경우 100>195
			//결과가 195/10=>20잘못됨, 다음처럼 나와서 위 조건을 타면 안되고  else문을 진입
			this.endPage = tempEnd;//tempEnd가 10이니깐 endPage가 10
		}
		//--------------------------endPage구하는 계산식 끝-------------
		//아래는 prev,next구하는 계산식
		this.prev = (this.startPage !=1);//예, 스타트페이지11 결과값은 true
		//시작페이지가 1보다 크면 무조건 이전페이지가 있다고 봄
		this.next = (this.endPage*this.queryPerPageNum < this.totalCount);
		//20x10 < 195 결과는 false이기 때문에 jsp에서 > 표시가 안보이게 처리함
		//예) < 11 12 13 14 15 16 17 18 19 20(tempEnd)  시작11 끝20
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		//perPageNum = 10;//강제로 1페이지당 보여줄 개수값을 10개로 지정
		this.perPageNum = perPageNum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public int getQueryStartNo() {
		//DB쿼리엣 사용 결과값은 시작 인덱스 번호(0)를 구하는 계산식 (아래)
		//계산식=(jsp에서 클릭한 페이지 번호-1)*페이지당 보여지는 갯수
		//1페이지게산 10[1페이지당 출력할갯수]x(1[몇번째페이지번호]-1) = 0 1페이지일때
		//2페이지게산 10x(2-1) = 10[계산결과] 2페이지일때
		queryStartNo = queryPerPageNum*(this.page-1);//개발자가 추가한 계산식//queryPerPageNum=10
		return queryStartNo;
	}
	public void setQueryStartNo(int queryStartNo) {
		this.queryStartNo = queryStartNo;
	}
	public boolean getPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean getNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//totalCount 변수값이 만들어지는 순간 calcPage메서드가 실행되면, 4개의 변수값 SET반환.
		calcPage();//totalCount 변수값이 필수로 필요한 메서드 입니다.
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	public int getQueryPerPageNum() {
		return queryPerPageNum;
	}

	public void setQueryPerPageNum(int queryPerPageNum) {
		this.queryPerPageNum = queryPerPageNum;
	}

	
	
}
