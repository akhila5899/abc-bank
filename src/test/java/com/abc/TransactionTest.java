package com.abc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }

    @Test
    public void testAmount(){
        Transaction transaction = new Transaction(200.0);
        assertEquals(200.0,transaction.getTransactionAmount());
    }

    @Test
    public void testTransactionDate(){
        Transaction transaction = new Transaction(100.0);
        assertNotNull(transaction.getTransactionDate());
    }
}
