package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

import java.util.function.Predicate;

public class AccountImpl implements Account {
    private AccountType accountType;
    private InterestStrategy interestStrategy;
    private String accountNumber;

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    private AccountImpl() {}

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void addInterest() {
        balance += balance * interestStrategy.getInterestPercentage();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    // Builder

    static class Builder{
        String accountNumber;
        AccountType accountType;
        InterestStrategy interestStrategy;
        public Builder(String accountNumber, AccountType accountType, InterestStrategy interestStrategy){
            this.accountType = accountType;
            this.accountNumber = accountNumber;
            this.interestStrategy = interestStrategy;
        }

        public Builder customer(Client client){
            return this;
        }

        public Account build(){
            AccountImpl account = new AccountImpl();
            account.accountNumber = accountNumber;
            account.accountType = accountType;
            account.interestStrategy = interestStrategy;
            return account;
        }
    }

}
