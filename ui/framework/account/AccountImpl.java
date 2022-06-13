package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class AccountImpl implements Account {
    private AccountType accountType;
    private InterestStrategy interestStrategy;

    private double balance = 0;

    public AccountImpl(AccountType accountType, InterestStrategy interestStrategy) {
        this.accountType = accountType;
        this.interestStrategy = interestStrategy;
    }

    @Override
    public void deposit(double balance) {
        balance += accountType.getDepositAmount(balance);
    }
    
}
