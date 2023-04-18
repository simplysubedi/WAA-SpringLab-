package miu.edu.lab1.aop;

import miu.edu.lab1.domain.ExceptionLog;
import miu.edu.lab1.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Aspect
@Configuration
public class ExceptionLogger {
    @Autowired
    ExceptionService exceptionService;
    final static String USERNAME = "Tom Murry";

final static String EXCEPTION_TYPE = "IgnoreType Error";
    @AfterThrowing(pointcut = "execution(* miu.edu.lab1.controller..*(..))",throwing = "e")
    public void saveTransaction(JoinPoint joinpoint, Exception e) {
        Random random = new Random();
        int userId = random.nextInt(100);
        ExceptionLog exception=new ExceptionLog(userId, LocalDate.now(), LocalTime.now(),USERNAME,joinpoint.getSignature().getName(),e.getMessage());
        exceptionService.addException(exception);
    }
}
