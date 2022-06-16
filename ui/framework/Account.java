package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;

import java.io.Serializable;

public interface Account extends Serializable {
    Transaction deposit(double amount);
    Transaction withdraw(double amount);
    void addInterest();
    double getBalance();


    String getAccountNumber();
    Client getClient();
    AccountTypeStrategy getAccountType();
    InterestStrategy getInterestStrategy();
 //   String getExpireDate();

}
