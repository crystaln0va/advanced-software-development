package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public interface AccountService {
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    String getReport();
    void addInterest();
    void createNewAccount(String accountNumber, AccountType accountType, InterestStrategy strategy);
}
