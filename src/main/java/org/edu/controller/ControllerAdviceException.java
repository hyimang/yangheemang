package org.edu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice //컨트롤러에서 발생되는 CRUD 액션을 중간에 가로채는 기능클래스 명시
public class ControllerAdviceException {
	
	//ModelAndView클래스는 jsp로 반환 시 값을 저장하는 역할
	//언제 아래 메서드가 실행될지 명시하는 클래스(아래)
	@ExceptionHandler(Exception.class)//컨트롤러에서 예외(에러)가 발생했을 때 아래 메서드를 자동실행
	public ModelAndView errorModelAndView(Exception ex, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		//AdminController에서 사용한 Model클래스는 jsp로 값을 보낼 때
		//여기서 사용하는 ModelAndView클래스는 jsp로 값을 보내고 + 반환값으로 model값을 보낼 jsp 경로도 지정
		//모델 값을 보낼 jsp 경로 지정하는 명령은 셋뷰네임입니다.
		modelAndView.setViewName("home/spring_error");//반환할 jsp 위치 지정
		modelAndView.addObject("exception", ex);
		//model.addAttribute("exception", ex);
		//return "home/error";
		String referer = request.getHeader("Referer");//이전페이지로 이동할 떄 필요한 링크값=크롬확인 가능한 헤더값
		request.getSession().setAttribute("prevPage", referer);
		//세션은 클라이언트가 서버에 접속 시 서버에서 발생하는 고유변수값을 세션이라고 하고, prevPage 세션키를 하나 생성(위)
		//세션에 저장된 prevPage키를 jsp에서 사용하게 됩니다.
		//결과로 jsp에서 사용가능한 변수 2가지: 오브젝트 변수(클래스변수)인 exception, 세션변수인 prevPage
		return modelAndView;
	}

}
