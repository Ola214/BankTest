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
    
}
