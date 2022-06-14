package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.InMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class TestingFactory implements AccountFactory {
    @Override
    public AccountDao getAccountDao() {
        return InMemoryAccountDao.INSTANCE;
    }

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public Rule getNotificationRule() {
        return null;
    }
}
