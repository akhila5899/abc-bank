package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }
    public double getTransactionAmount(){
        return amount;
    }

     public Date getTransactionDate(){
        return transactionDate;
    }
    

}
