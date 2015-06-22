/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Olaa
 */
public class Bank {
    private static Integer counter = 0;
    private Integer id;
    private List<User> userList;
    
    public Bank(){
        id = counter;
        counter++;
        userList = new LinkedList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<User> getUserList() {
        return userList;
    }
    
    public void addUser(User user){
        userList.add(user);
    }

    public User getUserAt(Integer index){
        return userList.get(index);
    }
    
    public void deleteUser(User user){
        userList.remove(user);
    }
    
    public Double getAccountState(Integer accountNumber){
        for(User user: userList){
            for(Account account: user.getAccountList()){
                if(account.getId().compareTo(accountNumber)==0){
                    return account.getAccountState();
                }
            }
        }
        return null;
    }
    
    public Map<Integer, Double> getAccountStatesOfUserAt(Integer idUser){
        Map<Integer, Double> accountsMap = new HashMap<>();
        for(User user: userList){
            if(user.getId().compareTo(idUser)==0){
                for(Account account: user.getAccountList()){
                    accountsMap.put(account.getId(), account.getAccountState());
                }
            }
        }
        return accountsMap;
    }
    
    /**
     * Adds money to account
     * @param accountNumber
     * @param amount
     */
    public void deposit(Integer accountNumber, Double amount){
        for(User user: userList){
            for(Account account: user.getAccountList()){
                if(account.getId().compareTo(accountNumber)==0){
                    account.setAccountState(account.getAccountState() + amount);
                }
            }
        }
    }
    
    /**
     * Withdraw some money from account
     * @param accountNumber
     * @param amount
     */
    public void withdraw(Integer accountNumber, Double amount){
        for(User user: userList){
            for(Account account: user.getAccountList()){
                if(account.getId().compareTo(accountNumber)==0){
                    account.setAccountState(account.getAccountState() - amount);
                }
            }
        }
    }
}
