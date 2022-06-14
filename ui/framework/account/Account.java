package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    void addInterest();
    double getBalance();

    String getAccountNumber();
}
