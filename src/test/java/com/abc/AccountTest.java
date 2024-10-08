/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Carrington
 */
public class AccountTest {

    public AccountTest() {
    }
    
    @Test
    public void testTransfer(){
        Account a1 = new Account(0);
        Account a2 = new Account(0);
        assertEquals(0,a1.sumTransactions(),0);
        a1.deposit(10000);
        a1.Transfer(a2, 5000);
        assertEquals(5000,a1.sumTransactions(),0);
        assertEquals(5000,a2.sumTransactions(),0);
    }

    @Test
    public void testSuperSavings(){
        Account account = new Account(2);
        account.deposit(2000);
        assertEquals(110.0,account.interestEarned());
}
