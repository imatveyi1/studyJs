/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.algorithms.testbean;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Матвей
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class TestBean implements Serializable {
    
    private int i;
    private List<Integer> list;    
    
}
