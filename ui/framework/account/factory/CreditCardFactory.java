package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.FileMemoryAccountDao;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.InMemoryAccountDao;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.CreditCardNotifier;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class CreditCardFactory implements AccountFactory {
    @Override
    public AccountDao getAccountDao() {
        return FileMemoryAccountDao.getInstance("CreditCard");
    }

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public Rule getNotificationRule() {
        return new CreditCardNotifier();
    }
}
