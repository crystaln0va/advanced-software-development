package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public enum InMemoryAccountDao implements AccountDao {
    INSTANCE;

    private HashMap<String, Account> accounts = new HashMap<>();

    public void saveAccount(Account account){
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccountByAccountNumber(String accountNumber){
        return Optional.ofNullable(accounts.get(accountNumber)).orElseThrow(() -> new RuntimeException("Not account found"));
    }

    public List<Account> getAllAccounts(){
        return accounts.values().stream().toList();
    }
}
