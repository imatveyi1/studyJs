/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.ksearch;


import com.my.algorithms.history.History;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Матвей
 */
@Component
public class MaxKElementSearch {
    
    private History history; 

    @Autowired
    public void setHistory(History history) {
        this.history = history;
    }
    
    public int[] getValueTest(int[] list, int k){
        
        Arrays.sort(list);
        return Arrays.copyOfRange(list, list.length - k, list.length);
    }
    
    
    public int[] getValue(int[] list, int k){
        if(list.length <= k){
            return list;
        }
        //проверяем не отсортирован ли массив
        boolean[] masSort = isSorting(list);
        //если отсортирован или все элементы одинаковы
        if(masSort[0]){
            return Arrays.copyOfRange(list, list.length - k, list.length); 
        }else if (masSort[1]){//если отсортирован в обратном порядке
            return Arrays.copyOfRange(list, 1, k);
        }
        // в противном случае дробим массив
        return splitting(list, k);

    }
    
    private int[] getKMaxElement(int[] list, int k){
        Arrays.sort(list);
        history.addToHistory(list);
        history.addToHistory(Arrays.copyOfRange(list, list.length - k, list.length));
        return Arrays.copyOfRange(list, list.length - k, list.length);
    }
    
    private boolean[] isSorting(int[] list){
        int i = 1;
        boolean isSortAsc = false;
        boolean isSortDesc = false;
        while(i<list.length){
            if(list[i-1] <= list[i]){
               if(isSortDesc){
                   isSortAsc = false;
                   isSortDesc = false;
                   break;    
                }
               isSortAsc = true;
               i++;
               continue;
            }
            if(isSortAsc){
                isSortAsc = false;
                isSortDesc = false;
                break;    
            }
            isSortDesc = true;
                i++;
        }
        boolean[] res = {isSortAsc, isSortDesc};
        return  res;
    }
    
    private int[] splitting(int[] list, int k){
        history.addToHistory(list);
        if(list.length/2 <= k){
            return getKMaxElement(list, k);
        }

        int[] massMax = new int[list.length];
        int j = -1;
            
        int i=0;
        // находим элементы большие за выбраный
        while(i<list.length){    
            if(list[i]>list[list.length/2]){
                j++;
                massMax[j] = list[i];
            }
            i++;
        }
        // если массив выбраных элементов меньше k ищем по массиву list
        if(j<k){
           return getKMaxElement(list, k); 
        }    
            
        return splitting(Arrays.copyOfRange(massMax, 0, j+1), k);
        
    }
    
  
    public List<List<Integer>> getHistory(){
        return history.getHistory();
    }
    
    public void deleteHistory(){
        history.deleteHistory();
    }
    
    
    
}
