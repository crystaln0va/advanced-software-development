package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Observer;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;
    private final AccountFactory factory;

    private final List<Observer> observers;

    public AccountServiceImpl(AccountFactory factory) {
        this.accountDao = factory.getAccountDao();
        this.factory = factory;
        this.observers = new ArrayList<>();
//        subscribe(new Notifier());
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        Transaction transaction = account.deposit(amount);

        accountDao.saveAccount(account);
        notifyChanges(transaction, account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        Transaction transaction = account.withdraw(amount);

        accountDao.saveAccount(account);
        notifyChanges(transaction, account);
    }

    @Override
    public String getReport() {
        accountDao.getAllAccounts().forEach(account -> System.out.println(account.getAccountNumber()+"-"+ account.getBalance()));
        return null;
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountDao.getAllAccounts();
        accounts.forEach(Account::addInterest);
        accounts.forEach(accountDao::saveAccount);

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
    public void notifyChanges(Transaction transaction, Account account) {
        for(Observer o : observers)
            o.update(transaction, account);

    }
}
