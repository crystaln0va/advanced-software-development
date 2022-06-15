package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Notifier;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Observer;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Subject;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService, Subject {

    private final AccountDao accountDao;
    private final AccountFactory factory;

    private final List<Observer> observers;

    public AccountServiceImpl(AccountFactory factory) {
        this.accountDao = factory.getAccountDao();
        this.factory = factory;
        this.observers = new ArrayList<>();
        subscribe(new Notifier(factory.getNotificationRule()));
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        Transaction transaction = account.deposit(amount);
        accountDao.saveAccount(account);
        boolean isApproved = true;
        notifyChanges(transaction, isApproved);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        Transaction transaction = account.withdraw(amount);

        boolean isApproved = true;
        if(transaction == null)
            isApproved = false;

        accountDao.saveAccount(account);
        notifyChanges(transaction, isApproved);
    }

    @Override
    public String getReport() {
        //accountDao.getAllAccounts().forEach(account -> System.out.println(account.getAccountNumber()+"-"+ account.getBalance()));
        
        return factory.getReportService().getReport(accountDao.getAllAccounts());
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountDao.getAllAccounts();
        accounts.forEach(Account::addInterest);
        accounts.forEach(account -> accountDao.saveAccount(account));

    }

    @Override
    public void createNewAccount(String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy) {
        Account account = new AccountImpl
                .Builder(accountNumber, accountType, strategy)
                .build();
        accountDao.saveAccount(account);
    }


    @Override
    public void subscribe(Observer o) {
        observers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyChanges(Transaction transaction, boolean isApproved) {
        for(Observer o : observers)
            o.update(transaction, isApproved );

    }
}
