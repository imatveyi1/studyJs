/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.controllers;

import com.my.algorithms.aop.testbean.TestBeanAop;
import com.my.algorithms.testbean.TestBean;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Матвей
 */
@RestController
@RequestMapping("/api")
public class TestController {
    
    @Autowired
    private TestBeanAop testBean;
    
    @RequestMapping(value = "/test")
    public TestBean test(@RequestParam("id") int id){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        testBean.test(id);
        return new TestBean(id, list); 
    }
    
}
