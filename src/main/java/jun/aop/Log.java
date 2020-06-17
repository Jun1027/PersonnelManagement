package jun.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 日志记录AOP
 * Create by Jun on 2020-06-04
 */
@Component
@Aspect
@Log4j
public class Log {

    @Pointcut("execution(* jun.service.impl.*.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LocalDateTime now = LocalDateTime.now();
        log.info("【"+now+"】调用了【"+className+"】类的【"+methodName+"】方法，传入的参数为：【"+ Arrays.toString(args)+"】");
        Object result = joinPoint.proceed();//放行方法
        log.info("【"+methodName+"】方法执行完毕，返回结果为：【"+result+"】");
        return result;
    }
}
