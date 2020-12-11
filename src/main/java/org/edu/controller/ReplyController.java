package org.edu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
