package com.example.financial_ledger_project.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect // AOP 클래스 선언: 부가 기능을 주입하는 클래스
@Component // IOC 컨테이너가 해당 객체를 생성 및 관리
@Slf4j
public class DebuggingAspect {

	// 대상 메소드 선택: CommentService#create()
	@Pointcut("execution(* com.example.financial_ledger_project.api.*.*(..))")
	private void cut() {}
	
	// 실행 시점 설정: cut()의 대상이 수행되기 이전
	@Before("cut()")
	public void loggingArgs(JoinPoint joinPoint) { // joinpoint -> cut()의 대상 메소드
		// 입력값 가져오기
		Object[] args = joinPoint.getArgs();

		// 클래스명
		String className = joinPoint.getTarget().getClass().getSimpleName();

		// 메소드명
		String methodName = joinPoint.getSignature().getName();

		// 입력값 로깅하기
		// CommentService#create()의 입력값 => 5
		// CommentService#create()의 입력값 => CommentDto(id=null, ...)
		for (Object obj : args) { // foreach 문
			log.info("{}#{}의 입력값 => {}", className, methodName, obj);
		}

	}

	// 실행 시점 설정: cut() 에 지정된 대상 호출 성공 후!
	@AfterReturning(value = "cut()", returning = "returnObj")
	public void logginReturnValue(JoinPoint joinPoint, Object returnObj) { // joinPoin --> cut()의 대상 메소드 // returnObj --> 리턴값

		// 클래스명
		String className = joinPoint.getTarget().getClass().getSimpleName();

		// 메소드명
		String methodName = joinPoint.getSignature().getName();

		log.info("{}#{}의 반환값 => {}", className, methodName, returnObj);
		
	}

}
