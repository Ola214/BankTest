/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ola.client;

import com.ola.server.Account;
import com.ola.server.Bank;
import com.ola.server.BankImpl;
import com.ola.server.User;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olaa
 */
public class BankTestMain {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new BankImpl();
        try {
            bank.getAccountState(2);
        } catch (Bank.NoAccountFoundException ex) {
            System.out.println("No account found");
            ex.printStackTrace();
        }

        User user = new User("ala", "makota", "a@gmail.com", bank.getId());
        Account account = new Account(user.getId());
        user.addAccount(account);
        bank.addUser(user);

        int counter = 0;
        boolean called = false;
        String surname = null;
        while (counter < 3) {
            if (called == false) {
                try {
                    System.out.println("Type surname");
                    surname = getUserInput();
                    bank.getAccountStatesOfUserAtSurname(surname);
                    called = true;
                } catch (Bank.NoUserFoundException ex) {
                    ex.printStackTrace();
                }
            }
            ++counter;
        }

        account.setAccountState(7.00);
        called = false;
        Double money = null;
        while (called == false) {
            try {
                System.out.println("Type amount of money you want to withdraw");
                money = Double.parseDouble(getUserInput());
                bank.withdraw(account.getId(), money);
                called = true;
            } catch (Bank.DebetException de) {
                de.printStackTrace();
            } catch (Bank.NegativeNumberException ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }

    }

    public static String getUserInput() {
        return scanner.nextLine();
    }

}
