package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;


import edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern.Observer;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern.Subject;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account, Subject {
    private AccountType accountType;
    private InterestStrategy interestStrategy;
    private List<Transaction> transactions = new ArrayList<>();
    private String accountNumber;


    private double balance = 0;

    public double getBalance() {
        return balance;
    }


    private void createTransaction(String description, double amount){
        transactions.add(new Transaction(LocalDate.now(), description, amount));
    }

    private AccountImpl() {}

    @Override
    public void deposit(double amount) {
        balance += amount;
        createTransaction("DEPOSIT", amount);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        createTransaction("WITHDRAW", amount);

    }

    @Override
    public void addInterest() {

        //balance += balance * interestStrategy.getInterestPercentage();
         balance += interestStrategy.calculateInterest(balance);
    }
//Observer Send Email

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }


    @Override
    public void registerObserver(Observer o) {
      //  observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
       // observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        //observers.forEach(o -> o.update(getBalance()));
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
