package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.io.Serializable;

public interface Account extends Serializable {
    Transaction deposit(double amount);
    Transaction withdraw(double amount);
    void addInterest();
    double getBalance();

    String getAccountNumber();
}
