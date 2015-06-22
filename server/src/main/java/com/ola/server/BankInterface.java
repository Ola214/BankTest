/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.server;

import java.util.Map;

/**
 *
 * @author Olaa
 */
public interface BankInterface {
    
    Double getAccountState(Integer accountNumber);
    
    Map<Integer, Double> getAccountStatesOfUserAt(Integer idUser);
    
    void deposit(Integer accountNumber, Double amount);
    
    void addUser(User user);
    
    User getUserAt(Integer index);
    
    void deleteUser(User user);
    
    void withdraw(Integer accountNumber, Double amount);
}
