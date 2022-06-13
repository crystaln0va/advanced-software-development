package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountImpl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.DefaultAccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.DefaultInterestStrategy;

public class Application {
    public static void main(String[] args) {
        Account account = new AccountImpl(new DefaultAccountType(), new DefaultInterestStrategy());
    }
}
