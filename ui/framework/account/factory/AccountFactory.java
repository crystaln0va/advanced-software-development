package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.ReportingService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

public interface AccountFactory {
    AccountDao getAccountDao();
    Account createAccount();
    ReportingService getReportService();

    Rule getNotificationRule();
}
