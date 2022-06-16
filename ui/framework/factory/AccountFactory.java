package edu.mum.cs.cs525.labs.exercises.project.ui.framework.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.report.ReportingService;

public interface AccountFactory {
    AccountDao getAccountDao();
    ReportingService getReportService();
}
