package org.edu.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.edu.dao.IF_BoardDAO;
import org.edu.dao.IF_MemberDAO;
import org.edu.vo.BoardVO;
import org.edu.vo.MemberVO;
import org.edu.vo.PageVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * JUnit 자바단위테스트이고, DataSource 지정후 DB(Hsql,Mysql,Oracle) 접속,
 * 데이터베이스 테이블에 Create, Read, Update, Delete 테스트용 클래스
 * 제이유닛4클래스를 사용.
 * 단위테스트는 톰캣이 실행되지 않아도 작동이 되야 합니다.
 * 그래서, 테스트 클래스 상단에 servelet-context.xml 이러한 설정파일을 불러들여서 실행이 가능
 * @author 김일국
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class DataSourceTest {

	@Inject
	DataSource dataSource;//자바에서처럼 new 오브젝트를 생성하지 않고, 스프링에서는 @Inject로 오브젝트 생성.
	
	@Inject
	IF_MemberDAO memberDAO;
	
	
	@Inject
	IF_BoardDAO boardDAO;
	
	@Inject//사용하면 안되는 이유: 클래스 상단에 @Controller, @Service, @Repository, @Component이런 내용있어야 @Inject가 가능함
	MemberVO memberVO;//기존자바처럼 new MemberVO() 오브젝트를 생성하지않고 주입해서 사용
	
	public String memberPrimaryKey() throws Exception {
		//사용자 프라이머리키 생성하는 메서드 년월일시분초+밀리초 대량더미데이터 입력시 Uniq 에러발생 UUID로 변경
		/*
		Date primaryKey = new Date();
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		System.out.println("프라이머리키: " + newFormat.format(primaryKey));
		return "user_" + newFormat.format(primaryKey);
		*/
		PageVO pageVO = new PageVO();
		pageVO.setPage(1);
		pageVO.setPerPageNum(8);//리스트하단에 보이는 페이징번호의 개수
		pageVO.setQueryPerPageNum(10);//쿼리에서 1페이지당 보여줄 게시물수 10개로 입력 놓았습니다.
		//검색된 전체 게시물수 구하기 서비스 호출
		int countMember = 0;
		countMember = memberDAO.countMember(pageVO);
		return "dummy_" + (countMember+1);
	}
	
	@Test
	public void updateMember() throws Exception{
		//CRUD 중 Update 테스트 구현 특징, user_id는 프라이머리 키이기 때문에 수정대상이 아님.
		//MemberVO memberVO = new MemberVO();
		memberVO.setUser_id("admin");
		memberVO.setUser_name("홍길동");
		memberVO.setUser_pw("");//암호를 수정하지 않는 사람을 가정
		memberVO.setEmail("test@test.com");
		memberVO.setPoint(100);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_ADMIN");
		String user_id = memberVO.getUser_id();//memberVO의 오브젝트의 데이터는 1개의 레코드이기 때문에 반환값이 1개만 반환
		memberDAO.updateMember(memberVO);		
	}
	
	@Test
	public void readMember() throws Exception{
		//CRUD 중 Read 테스트 구현
		//MemberVO memberVO = new MemberVO();
		memberVO = memberDAO.readMember("admin");
		System.out.println("admin에 대한 상세정보입니다.");
		System.out.println(memberVO.toString());
	}
	
	@Test
	public void deletMember() throws Exception{
		//CRUD 중 Delete 테스트구현(쿼리->DAO->memberDAO주입받은 오브젝트 사용)
		memberDAO.deletMember("user_20201215145624260");//삭제메서드 ->쿼리 호출
	}
	
	@Test
	public void insertBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("더미게시물");
		boardVO.setContent("더미 내용 입니다.");
		boardVO.setWriter("일반사용자");
		//boardVO.setBno(프라이머리키);
		for(int cnt=0;cnt<=100;cnt++) {//더미게시물 100입력
			boardDAO.insertBoard(boardVO);
		}
	}

	
	@Test
	public void insertMember() throws Exception {
		//CRUD 중 Create 테스트
		//MemberVO memberVO = new MemberVO();
		//사용자 생성규칙: user 시작(prefix),suffix(접미사)는 년월일시분초
		//사용자 생성결과 예: user_20201215142132
		//String memberIdKey = memberPrimaryKey();
		
		memberVO.setUser_name("사용자03");
		//패스워드 암호화처리(필수이지만 스프링시큐리때 엔코더처리)
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberVO.setUser_pw(passwordEncoder.encode("1234"));
		memberVO.setEmail("user03@abc.com");
		memberVO.setPoint(100);
		memberVO.setEnabled(true);
		memberVO.setLevels("ROLE_USER");
		Date reg_date = new Date();
		memberVO.setReg_date(reg_date);//매퍼쿼리에서 처리로 대체
		for(int cnt=0;cnt<=100;cnt++) {
			
			memberVO.setUser_id(memberPrimaryKey());
			memberDAO.insertMember(memberVO);
		}
	}
	
	@Test
	public void selectMember() throws Exception {
		//"user_name","길동"
		PageVO pageVO = new PageVO();
		pageVO.setSearch_type("user_name");
		pageVO.setSearch_keyword("메롱");
		//아래 3개줄은 초기 페이징처리에 필요한  필수값 저장
		pageVO.setPage(1);
		pageVO.setPerPageNum(5);//리스트하단에 보이는 페이징번호의 갯수
		pageVO.setQueryPerPageNum(10);//쿼리에서 1페이지당 보여줄 회원수 10명으로 입력놓았습니다.
		List<MemberVO> memberList =	memberDAO.selectMember(pageVO);
		System.out.println("회원리스트 테스트 입니다.");
		System.out.println(memberList.toString());
	}
	@Test
	public void oldQueryTest() throws Exception{
		//Connection connection = dataSource.getConnection();
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:hsqldb:file:e:/egov/workspace/embeded/hsql_file.db;hsqldb.lock_file=false","sa","");
		//직접쿼리를 날립니다.
		Statement stmt = connection.createStatement();
		
		/* 인서트 쿼리 실행 */
		/*
		for(int cnt=0;cnt<=100;cnt++) {//고정방식으로 더미데이터 입력하기
		stmt.executeQuery("INSERT INTO tbl_board VALUES("
				+ "(select count(*) from tbl_board)+1"
				+ ",'강제 수정된 글입니다.', '수정테스트', 'user00', now(),now(),0,0)");
		}
		*/
		/* 셀렉트 쿼리 실행(아래) */
		ResultSet rs = stmt.executeQuery("select * from tbl_board");
		System.out.println("번호\t\t제목\t\t내용\t\t작성자");
		while(rs.next()) {
			System.out.print(rs.getString("bno"));
			System.out.print(rs.getString("title"));
			System.out.print(rs.getString("content"));
			System.out.print(rs.getString("writer"));
			System.out.println();
		}
		if(rs !=null)rs.close();
		if(stmt !=null)stmt.close();
		if(connection !=null)connection.close();
	}
	
	@Test
	public void dbConnectionTest() throws Exception {
		try {//내부에서 {} 에러발생시 실행을 중지하고, catch{}구문이 실행 됩니다. 예외처리라고 합니다.
			Connection connection = dataSource.getConnection();
			System.out.println("데이터베이스 접속이 성공하였습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속에 실패햐였습니다. 왜냐하면 " + e);
			//e.printStackTrace();
		}//DB커넥션 오브젝트 만드는 과정. new 사용안함.
		//try~catch는 테스트에서만 사용하고, 스프링에서는 throws Exception으로 예외를 스프링으로 보냅니다.
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
		System.out.println("JUnit테스트 시작 입니다.");
	}

}