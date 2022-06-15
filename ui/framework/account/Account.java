package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;

import java.io.Serializable;

public interface Account extends Serializable {
    Transaction deposit(double amount);
    Transaction withdraw(double amount);
    void addInterest();
    double getBalance();
    AccountTypeStrategy getAccountType();

    String getAccountNumber();
}
