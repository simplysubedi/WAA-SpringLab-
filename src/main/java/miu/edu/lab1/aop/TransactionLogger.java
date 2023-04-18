package miu.edu.lab1.aop;

import miu.edu.lab1.domain.Logger;
import miu.edu.lab1.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

@Aspect
@Configuration
public class TransactionLogger {
    final static String USERNAME = "Tom Murry";
    @Autowired
    LoggerService loggerService;

    @After("execution(* miu.edu.lab1.controller..*(..))")
    public void saveTransaction(JoinPoint joinpoint) {
        Random random = new Random();
        int userId = random.nextInt(100);
        loggerService.addTransaction(new Logger(userId, LocalDate.now(), LocalTime.now(), USERNAME, joinpoint.getSignature().getName()));
    }

}
