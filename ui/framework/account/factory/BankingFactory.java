package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.FileMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.PersonalBankingNotifier;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class BankingFactory implements AccountFactory{
    @Override
    public AccountDao getAccountDao() {
        return new FileMemoryAccountDao("banking");
    }

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public Rule getNotificationRule() {
        return new PersonalBankingNotifier();
    }
}
