package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountServiceImpl;

public class Application {
    public static void main(String[] args) {
        AccountService service = new AccountServiceImpl(new BankingFactory());


        service.deposit("12345", 50);

        service.getReport();
    }
}
