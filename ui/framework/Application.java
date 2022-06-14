package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;


import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.BankingFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.CreditCardFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.banking_account.CheckingAccountStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.credit_card.GoldStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.banking_account.SavingAccountStrategy;


public class Application {
    public static void main(String[] args) {
        AccountService bankingService = new AccountServiceImpl(new BankingFactory());
        AccountService creditCardService = new AccountServiceImpl(new CreditCardFactory());

        creditCardService.createNewAccount("12345", AccountType.CreditCard, new GoldStrategy());
        creditCardService.deposit("12345", 50);
        creditCardService.withdraw("12345", 5);

        bankingService.createNewAccount("987456", AccountType.Personal, new CheckingAccountStrategy());
        bankingService.deposit("987456", 5000);
        bankingService.withdraw("987456", 100);

        bankingService.createNewAccount("12341218749", AccountType.Company, new SavingAccountStrategy());
        bankingService.deposit("12341218749", 300000);
        bankingService.withdraw("12341218749", 30000);

        System.out.println("card Report");
        creditCardService.getReport();
        creditCardService.addInterest();
        creditCardService.getReport();
        System.out.println("bank Report");
        bankingService.getReport();
      bankingService.addInterest();
      bankingService.getReport();


    }
}
