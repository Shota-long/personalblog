package com.it.personalblog1_0.interceptor.exceptioninterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/23 16:45
 *
 * @ControllerAdvice拦截所有的Contrller
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(HttpServletRequest req , Exception e) throws Exception {

        logger.error("RequestUrl:{},Exception:{}",req.getRequestURL(),e.getMessage());

        //存在异常并且指定了异常状态码，直接抛出异常
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",req.getRequestURI());
        mv.addObject("exception",e);
        //指定返回页面在/error/error.html
        mv.setViewName("/error/error");
        return mv;
    }
}


