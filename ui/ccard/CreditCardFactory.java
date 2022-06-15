package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.FileMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.ReportingService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

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
        return new CreditCardNotifierRule();
    }

    @Override
    public ReportingService getReportService() {
        return new CreditCardReportService();
    }
}
