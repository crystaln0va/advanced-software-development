package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Subject;

public interface AccountService extends Subject {
    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    String getReport();

    void addInterest();

    void createNewAccount(Client client, String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy);
}
