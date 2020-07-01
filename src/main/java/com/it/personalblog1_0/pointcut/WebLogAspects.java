package com.it.personalblog1_0.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/22 22:05
 */
@Aspect
@Component
public class WebLogAspects {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.it.personalblog1_0.controller.UserController.*(..))")
    private void userPointCut(){}

    /**在方法执行前切入*/
    @Before(value = "userPointCut()")
    private void BeforeUserContorl(JoinPoint joinPoint){
        logger.info("UserController类准备执行...");
        //获取HttpRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //获取类名和方法名
        String className = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //构建对象
        RequestLog requestLog = new RequestLog(url,ip,className,args);
        logger.info("RequestLog{}",requestLog);


    }
    /**在方法执行后切入*/
    @After(value = "userPointCut()")
    private void AfterUserContorl(){
        logger.info("UserController类执行完毕...");
    }
    /**获取方法返回值*/
    @AfterReturning(returning = "result",value = "userPointCut()")
    public void getReturnValue(Object result){
        logger.info("result:{}",result);
    }

    /**定义一个内部类对象，来接受url等信息*/

    class RequestLog{

        private String url;
        private String ip;
        private String className;
        private Object[] args;

        public RequestLog(String url, String ip, String className, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.className = className;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", className='" + className + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
