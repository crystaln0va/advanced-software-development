package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.BankingFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.CreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.TestingFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.banking_account.CheckingAccountStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.banking_account.SavingAccountStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.credit_card.GoldStrategy;


public class Application {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl(new BankingFactory());
        AccountService accountService2 = new AccountServiceImpl(new CreditCardFactory());

        accountService.createNewAccount("12345", AccountType.CreditCard, new GoldStrategy());
        accountService.deposit("12345", 50);

        accountService.createNewAccount("987456", AccountType.Personal, new CheckingAccountStrategy());
        accountService.deposit("987456", 5000);

        accountService2.createNewAccount("12341218749", AccountType.Company, new SavingAccountStrategy());
        accountService2.deposit("12341218749", 300000);

        accountService.getReport();
        accountService.addInterest();
        accountService.getReport();


    }
}
