package com.abc;


import java.util.*;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
          return accounts.stream().mapToDouble(Account:: interestEarned).sum();
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        String s  =" ";
      Map<String,String> accountType  = new HashMap<>();
      accountType.put(Account.CHECKING,"Checking Account");
      accountType.put(Account.SAVINGS,"Savings Account");
      accountType.put(Account.MAXI_SAVINGS,"Maxi Savings Account");
      accountType.put(Account.SUPER_SAVINGS,"Super Savings Account");
                
        s+=" Account Type: " += accountType.get(a.getType())+" \n";

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }

    public void transfer(Account fromAccount, Account toAccount,double amount){
        if(fromAccount.interestEarned() > = toAccount.interestEarned()){
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
        else
            throw new IllegalArgumentException("Unable to transfer funds");
    }
}
