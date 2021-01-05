package org.edu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.edu.vo.ReplyVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReplyController.java 클래스
 * 댓글 구현 Rest-API 전용 컨트롤러=RestAPI서버
 * @author 양희망
 *
 */
@RestController
public class ReplyController {
	
	//댓글리스트 메서드
	@RequestMapping(value="/reply/reply_list/{bno}", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> reply_list(@PathVariable("bno") Integer bno){
		System.out.println("디버그: 패스베리어블 변수는" + bno);
		ResponseEntity<Map<String,Object>> result = null;
		
		ReplyVO replyVO = new ReplyVO();
		String replyRead = replyVO.toString();
		
		Map<String,Object> resultMap = new HashMap<String,Object>();//해시맵타입으로 Json 저장소 생성
		//Map변수=데이터형 [{'key':'List<>'},{'key':'ClassVO'},{'':''},...]
		Map<String,Object> dummyMap1 = new HashMap<String,Object>();
		dummyMap1.put("rno", "1");
		dummyMap1.put("replyer", "관리자");
		dummyMap1.put("reply_text", "컨트롤1 댓글 입력 테스트입니다.");
		Map<String,Object> dummyMap2 = new HashMap<String,Object>();
		dummyMap2.put("rno", "2");
		dummyMap2.put("replyer", "관리자2");
		dummyMap2.put("reply_text", "컨트롤2 댓글 입력 테스트입니다.");
		List<Object> dummyMapList = new ArrayList<Object>();
		dummyMapList.add(0, dummyMap1);
		dummyMapList.add(1, dummyMap2);
		//------------------------------------------------------
		resultMap.put("replyList", dummyMapList);//Put메서드로 Key:Val 제이슨 데이터 생성
		//resultMap을 Json데이터로 반환하려면, jackson-detabind 모듈이 필수(pom.xml)
		result = new ResponseEntity<Map<String,Object>>(resultMap,HttpStatus.OK);
		//HttpStatus.No_CONTENT는 204 조회된 데이터가 없음 코드
		return result;
	}
	
	//댓글 입력 메서드
	@RequestMapping(value="/reply/reply_write",method=RequestMethod.POST)
	public ResponseEntity<String> reply_write(){
		ResponseEntity<String> responseEntity = 
				new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		//ResponseEntity는 json텍스트를 반환한느데, 전송내용:"SUCCESS", 전송상태-HttpStatus.OK
		//text-body:e.getMessage()실패메세지값, 전송상태-HttpStatus.BAD_REQUEST(400):e.getMessage()실패메세지값)
		return responseEntity;
	}
	//기존 @Controllerdml 메서드 반환값은 파일위치,
	//대신에 @RestController의 메서드 반환값은 json텍스트(전송내용,전송상태값)로 Ajax로 호출한 jsp로 리턴값을 보내게 됩니다.
}
