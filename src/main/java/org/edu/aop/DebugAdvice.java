package org.edu.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * DebugAdvice 클래스로서 디버그를 Advice라는AOP기능을 사용해서 디버그를 실행하게 됨
 * @author 양희망
 *
 */
@Component//스프링빈으로 사용하겠다를 명시
@Aspect//AOP기능을 사용하겠다를 명시
public class DebugAdvice {
	private static final Logger logger = LoggerFactory.getLogger(DebugAdvice.class);
	/**
	 * @throws Throwable 
	 * @Around 에노테이션 클래스는 메서드실행에 직접 관여함
	 * Around 클래스타입의 파라미터(매개변수)로 ProceedingJoinPoint 타입의 클래스를 씀
	 * ProceedingJoinPoint클래스는 JoinPoint(실행지점)의 모든메서드를 가지면서,
	 * 직접 타겟클래스의 메서드를 실행할 수 있는 기능이 있음
	 * ProceedingJoinPoint.proceed()메서드는 특이하게도 Exception클래스보다 상위의 예외 전달합니다.
	 * 즉, 일반 내부 Exception 에러처리보다 ProceedingJoinPoint.proceed()메서드가 먼저 처리함
	 * proceed()메서드 생성에  Throwable을 사용하고, 시간을 체크하는 기능을 작성할 수 있습니다.
	 * 시간 체크하는 기능이 필유한 이유? 개발자가 만든 다양한 메서드의 시작과 끝 시간을 체크가능
	 * 예를 들어 개발자가 만든 클래스를 실행시켰을때, 5~10분이상 느리게 진행되는 현상이 생김
	 * 어느 메서드에서 시간이 얼만큼 소요되는 지 확인해야만 트러블 슈팅이 가능함
	 * 아래 @Around() 애노테이션 클래스의 ()는 디버그할 영역지정
	 * MemberService*모든 클래스(Impl)에서 .*(..) (모든이름의 메서드를 포함)
	 */
	@Around("execution(* org.edu.service.MemberService*.*(..))")
	//@Around("execution(* org.edu.controller.AdminController.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("AOP 디버그 시작=====================");
		long startTime = System.currentTimeMillis();//현재 컴퓨터 시간을 저장하는 변수
		logger.info(Arrays.toString(pjp.getArgs()));//pjp클래스 매개변수 값 GET으로 가져와서 toString형 변환해서 출력
		//위) 현재 시간체크하는 메서드가 어떤 메서드인지 눈으로 확인하려고 logger.debug로 출력
		Object result = pjp.proceed();//AdminController에 있는 메서드가 실행됨(시간이 소요됨)
		long endTime = System.currentTimeMillis();//현재 컴퓨터 시간을 저장하는 변수
		logger.info(pjp.getSignature().getName() + "()메서드명 의 실행시간은:" + (double)(endTime-startTime)/1000 + "초 입니다.");
		logger.info("AOP 디버그 끝======================");
		return result;
	}
	
}
