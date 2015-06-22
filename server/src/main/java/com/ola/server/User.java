/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.server;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Olaa
 */
public class User {

    private static Integer id = 0;
    private Integer idBank;
    private String name;
    private String surname;
    private String email;
    private List<Account> accountList;

    
    public User(String name, String surname, String email, Integer idBank){
        id++;
        accountList = new LinkedList<>();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.idBank = idBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
    
    public Account getAccountAt(Integer index){
        return accountList.get(index);
    }
    public void addAccount(Account account){
        accountList.add(account);
    }
    
    public void deleteAccount(Account account){
        accountList.remove(account);
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }
    
    
}
