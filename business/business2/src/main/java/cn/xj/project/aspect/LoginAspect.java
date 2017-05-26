package cn.xj.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Welink on 2017/4/12.
 */
@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(public * cn.xj.project.controller..*(..))")
    public void aspect() {

    }

    @Before(value = "aspect()")
    public void before(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object loginInfo = request.getSession().getAttribute("loginInfo");
        if (loginInfo == null) {
            System.out.println("未登录");
        }
        System.out.println(point.getSignature().getDeclaringTypeName() + "," + point.getSignature().getName());
    }

}
