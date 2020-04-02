package cn.stevekung.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // 标注为是一个切面
@Component
public class DiyPointCut {
    @Before("execution(* cn.stevekung.service.UserServiceImpl.getUserService(..))")
    public void before(){
        System.out.println("===before===");
    }
    @After("execution(* cn.stevekung.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("==after==");
    }
}
