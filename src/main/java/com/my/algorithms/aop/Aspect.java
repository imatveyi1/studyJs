/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.aop;

/**
 *
 * @author Матвей
 */
public class Aspect {
    
     public void init(){ 
        System.out.println("addAppender"); 
    } 
    public void before(){ 
        System.out.println("Before method..."); 
    } 
    public void after(){ 
        System.out.println("After method..."); 
    } 
    public void afterReturning(){ 
        System.out.println("After returning..."); 
    } 
    public void afterThrowing(){ 
        System.out.println("After throwing..."); 
    } 
    
}
