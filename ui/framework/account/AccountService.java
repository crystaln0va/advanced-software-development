package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public interface AccountService {
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    String getReport();
    void addInterest();
    void createNewAccount(String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy);
}
