package miu.edu.lab1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@Aspect
@Configuration

public class ExecutionTime {
    @Around("execution(* miu.edu.lab1.controller.UserController.findUserById(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch stopWatchw = new StopWatch();
        stopWatchw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        stopWatchw.stop();
        long totalTime = stopWatchw.getLastTaskTimeMillis();
        System.out.println("Total Time : " + totalTime +"ns");
        return retVal;
    }


}
