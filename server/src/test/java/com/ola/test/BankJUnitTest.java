/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.test;

import com.ola.server.Account;
import com.ola.server.Bank;
import com.ola.server.Bank.DebetException;
import com.ola.server.BankImpl;
import com.ola.server.Bank.NegativeNumberException;
import com.ola.server.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Olaa
 */
public class BankJUnitTest {
    
    private Bank bank;
    
    public BankJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        bank = new BankImpl();
    }
    
    @After
    public void tearDown() {
        bank = null;
    }

    @Test(expected = Bank.NegativeNumberException.class)
    public void depositNegativeAmountOfMoneyTest() throws NegativeNumberException{
        User user = new User("ala", "makota", "a@gmail.com", bank.getId());
        Account account = new Account(user.getId());
        user.addAccount(account);
        bank.addUser(user);
        bank.deposit(account.getId(), -2.00);
    }
    
    @Test
    public void depositPositiveAmountOfMoneyTest() throws NegativeNumberException{
        User user = new User("ala", "makota", "a@gmail.com", bank.getId());
        Account account = new Account(user.getId());
        user.addAccount(account);
        bank.addUser(user);
        bank.deposit(account.getId(), 2.00);
    }
    
    @Test(expected = Bank.NegativeNumberException.class)
    public void withdrawNegativeAmoutOfMoneyTest() throws NegativeNumberException, Bank.DebetException{
        User user = new User("ala", "makota", "a@gmail.com", bank.getId());
        Account account = new Account(user.getId());
        user.addAccount(account);
        bank.addUser(user);
        bank.withdraw(account.getId(), -2.00);
    }
    
    @Test(expected = Bank.DebetException.class)
    public void isDebetTest() throws DebetException, NegativeNumberException{
        User user = new User("ala", "makota", "a@gmail.com", bank.getId());
        Account account = new Account(user.getId());
        user.addAccount(account);
        bank.addUser(user);
        bank.withdraw(account.getId(), 2.00);
    }
    
    @Test(expected = Bank.NoUserFoundException.class)
    public void getAccountStatesOfNotExistingUserAtSurnameTest() throws Bank.NoUserFoundException{
        bank.getAccountStatesOfUserAtSurname("makota");
    }
    
    @Test(expected = Bank.NoAccountFoundException.class)
    public void getNotExistingAccountStateTest() throws Bank.NoAccountFoundException{
        bank.getAccountState(7);
    }
}
