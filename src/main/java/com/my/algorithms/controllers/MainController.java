/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 *
 * @author Матвей
 */
@Controller
public class MainController {
    
    
    @RequestMapping({"/", "/index", "/main"})
    public String getMainView(){
        ModelAndView mav = new ModelAndView("index"); 
        System.out.println("view name = " + mav.getViewName());
        return mav.getViewName();
    } 
    
}
