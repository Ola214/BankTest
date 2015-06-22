/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.server;

/**
 *
 * @author Olaa
 */
public class Bank {
    private static Integer counter = 0;
    private Integer id;
    
    public Bank(){
        id = counter;
        counter++;
    }

    public Integer getId() {
        return id;
    }

    
    
    
}
