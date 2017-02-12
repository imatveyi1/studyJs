/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Матвей
 */
@Component
public class History {
    
    private final List<List<Integer>> history = new ArrayList();
    
    public void addToHistory(int[] mass){
        history.add(addToListFromMass(mass));
    }
    
    public void deleteHistory(){
        history.clear();
    }
    
    public List<List<Integer>> getHistory(){
        return history;
    }
    
    private List<Integer> addToListFromMass(int[] mass){
        List<Integer> res = new ArrayList();
        Arrays.stream(mass).forEach(m -> res.add(m));
        return res;
    }
    
}
