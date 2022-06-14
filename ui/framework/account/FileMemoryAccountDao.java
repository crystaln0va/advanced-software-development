package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.util.List;

public class FileMemoryAccountDao implements AccountDao {

    private final String filePath;

    public FileMemoryAccountDao(String filePath){
        this.filePath = filePath;
    }


    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }
}
