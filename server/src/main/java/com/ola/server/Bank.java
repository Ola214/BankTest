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
public class Bank implements BankInterface{
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
    
    @Override
    public void addUser(User user){
        userList.add(user);
    }

    @Override
    public User getUserAt(Integer index){
        return userList.get(index);
    }
    
    @Override
    public void deleteUser(User user){
        userList.remove(user);
    }
    
    @Override
    public Double getAccountState(Integer accountNumber) throws NoAccountFoundException{
        for(User user: userList){
            for(Account account: user.getAccountList()){
                if(account.getId().compareTo(accountNumber)==0){
                    return account.getAccountState();
                }
            }
        }
        throw new NoAccountFoundException();
    }
    
    @Override
    public Map<Integer, Double> getAccountStatesOfUserAtSurname(String surname) throws NoUserFoundException{
        Map<Integer, Double> accountsMap = new HashMap<>();
        for(User user: userList){
            if(user.getSurname().equals(surname)){
                for(Account account: user.getAccountList()){
                    accountsMap.put(account.getId(), account.getAccountState());
                }
            }
        }
        if(!accountsMap.isEmpty())
            return accountsMap;
        
        throw new NoUserFoundException();  
    }
    
    /**
     * Adds money to account
     * @param accountNumber
     * @param amount
     * @throws com.ola.server.BankInterface.NegativeNumberException
     */
    @Override
    public void deposit(Integer accountNumber, Double amount) throws NegativeNumberException{
        if(amount <= 0)
            throw new NegativeNumberException();
        
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
     * @throws com.ola.server.BankInterface.NegativeNumberException
     * @throws com.ola.server.BankInterface.DebetException
     */
    @Override
    public void withdraw(Integer accountNumber, Double amount) throws NegativeNumberException, DebetException{
        if(amount <= 0)
            throw new NegativeNumberException();
        
        for(User user: userList){
            for(Account account: user.getAccountList()){
                if(account.getId().compareTo(accountNumber)==0){
                    if((account.getAccountState() - amount) < 0)
                        throw new DebetException();
                        
                    account.setAccountState(account.getAccountState() - amount);
                }
            }
        }
    }

}
