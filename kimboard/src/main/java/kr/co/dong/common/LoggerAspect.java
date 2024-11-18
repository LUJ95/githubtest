/* pom.xml에서 메이븐설정
 * 		<!-- AspectJ -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>${org.aspectj-version}</version>
		</dependency>	
		
 * 
 */
package kr.co.dong.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// advice : 공통업무를 지원하는 클래스
@Component
@Aspect
public class LoggerAspect {
	protected Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	String type = "";
	
	//@before(해당 대상이 호출전)
	@Around("execution(* kr.co.dong.controller.*Controller.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		//핵심업무 실행전
		Object result = null;
		type = joinPoint.getSignature().getDeclaringTypeName();
		long start = System.currentTimeMillis();
		//핵심업무 실행
		result = joinPoint.proceed();
		//핵심업무 실행후
		long end = System.currentTimeMillis();
		log.info("->" + type + " : 수행시간 " +(end-start)+"밀리초");
		
		return result;
	}
}







