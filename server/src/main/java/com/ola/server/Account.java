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
public class Account {

    private static Integer id = 0;
    private Integer idUser;
    private Double accountState;
    
    public Account(Integer idUser){
        id++;
        this.idUser = idUser;
        accountState = 0.00;
    }
    
    public Integer getIdUser(){
        return idUser;
    }
    
    public void setIdUser(Integer idUser){
        this.idUser = idUser;
    }

    public Double getAccountState() {
        return accountState;
    }

    public void setAccountState(Double accountState) {
        this.accountState = accountState;
    }
    
}
