package fr.univlyon1.m1if.m1if03.tp4.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerException extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) {
        if (excptn instanceof MethodArgumentNotValidException) {
            ModelAndView model = new ModelAndView("error-page");
            model.addObject("error", 400);
            return model;
        }
        
        return null;
    }
}
