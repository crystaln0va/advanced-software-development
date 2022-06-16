package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Observer;

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
        return factory.getReportService().generateReport(accountDao);
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountDao.getAllAccounts();
        accounts.forEach(Account::addInterest);
        accounts.forEach(accountDao::saveAccount);
    }

    @Override
    public List<Account> getAllAccounts() {
        return   accountDao.getAllAccounts();
    }

    @Override
    public void createNewAccount(Client client, String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy) {
        Account account = new AccountImpl(client, accountNumber, accountType, strategy);
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
