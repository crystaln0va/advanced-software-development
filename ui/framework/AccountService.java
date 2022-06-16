package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Subject;


import java.util.List;

public interface AccountService extends Subject {

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    String getReport();

    void addInterest();
    List<Account> getAllAccounts();

    void createNewAccount(Client client, String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy);
}
