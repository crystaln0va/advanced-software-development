package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountImpl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.DefaultAccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.TestingFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.DefaultInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.GoldStrategy;

public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl(new TestingFactory());

        accountService.createNewAccount("12345", new DefaultAccountType(), new DefaultInterestStrategy());

        accountService.deposit("12345", 50);

        accountService.getReport();
    }
}
