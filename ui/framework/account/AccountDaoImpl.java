package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    List<Account> accountList = new ArrayList<>();

    @Override
    public void saveAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return (Account) accountList.stream().filter(acc -> acc.getAccountNumber().equals(accountNumber));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountList;
    }
}