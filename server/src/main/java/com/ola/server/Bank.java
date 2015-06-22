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
public interface Bank {
    
    Integer getId();
            
    Double getAccountState(Integer accountNumber) throws NoAccountFoundException;
    
    Map<Integer, Double> getAccountStatesOfUserAtSurname(String surname) throws NoUserFoundException;
    
    void deposit(Integer accountNumber, Double amount) throws NegativeNumberException;
    
    void addUser(User user);
    
    User getUserAt(Integer index);
    
    void deleteUser(User user);
    
    void withdraw(Integer accountNumber, Double amount) throws NegativeNumberException, DebetException;
    
    class NoAccountFoundException extends Exception{}; //you must warn when you use Exception, if u use RuntimeException you don't have to(u don't have to specify it)
    
    class NoUserFoundException extends Exception{};
    
    class DebetException extends Exception{};
    
    /**
     * Negative number - 0 or below
     */
    class NegativeNumberException extends Exception{};
}
