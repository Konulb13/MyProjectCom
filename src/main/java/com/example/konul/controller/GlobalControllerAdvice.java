package com.example.konul.controller;

import com.example.konul.entity.User;
import com.example.konul.service.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@ControllerAdvice
public class GlobalControllerAdvice {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private ShoppingCartService shoppingCartService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @ModelAttribute
    public void populateModel(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            if(user != null){
                model.addAttribute("shoppingCartItemNumber",shoppingCartService.getItemsNumber(user));
            }
        }else {
            model.addAttribute("shoppingCartItemNumber",0);
        }
    }
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
            throw ex;

//        // Log the exception
//        log.error("Exception occurred at path: " + req.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("timestamp", new Date(System.currentTimeMillis()));
        modelAndView.addObject("path", req.getRequestURL());
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);

        //modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);  //json error

        return modelAndView;
    }

}
