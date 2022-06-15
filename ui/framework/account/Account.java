package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;

import java.io.Serializable;

public interface Account extends Serializable {
    Transaction deposit(double amount);
    Transaction withdraw(double amount);
    void addInterest();
    double getBalance();
    AccountTypeStrategy getAccountType();

    String getAccountNumber();
    Client getClient();
}
