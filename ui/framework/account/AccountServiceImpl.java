package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountTypeOld;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;
    private final AccountFactory factory;

    public AccountServiceImpl(AccountFactory factory) {
        this.accountDao = factory.getAccountDao();
        this.factory = factory;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        account.deposit(amount);
        accountDao.saveAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDao.getAccountByAccountNumber(accountNumber);
        account.withdraw(amount);
        accountDao.saveAccount(account);
    }

    @Override
    public String getReport() {
        accountDao.getAllAccounts().forEach(account -> System.out.println(account.getBalance()));
        return null;
    }

    @Override
    public void addInterest() {
        List<Account> accounts = accountDao.getAllAccounts();
        accounts.forEach(Account::addInterest);
    }

    @Override
    public void createNewAccount(String accountNumber, AccountType accountType, InterestStrategy strategy) {
        Account account = new AccountImpl
                .Builder(accountNumber, accountType, strategy)
                .build();
        accountDao.saveAccount(account);
    }
}
