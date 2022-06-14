package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.FileMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.InMemoryAccountDao;

public class CreditCardFactory implements AccountFactory{
    @Override
    public AccountDao getAccountDao() {
        return FileMemoryAccountDao.getInstance("CreditCard");
    }

    @Override
    public Account createAccount() {
        return null;
    }
}
