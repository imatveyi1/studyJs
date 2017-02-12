/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.controllers;

import com.my.algorithms.ksearch.MaxKElementSearch;
import java.util.List;
import java.util.Random;
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
public class MaxKElementSearchController {
    
    private MaxKElementSearch maxKElementSearch;

    @Autowired
    public void setMaxKElementSearch(MaxKElementSearch maxKElementSearch) {
        this.maxKElementSearch = maxKElementSearch;
    }
     
    @RequestMapping(value = "/search/kelement")
    public List<List<Integer>> test(@RequestParam("count") int count, @RequestParam("k") int k){
        
        maxKElementSearch.deleteHistory();
        int[] list = new int[count];

        Random r = new Random();
        
        for(int i=list.length-1; i>=0; i--){
            int n = r.nextInt();
            list[i] = n;
        }
        maxKElementSearch.getValue(list, k);
        
        return maxKElementSearch.getHistory();
        
    }
    
}
