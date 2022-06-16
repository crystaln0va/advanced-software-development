package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.FileMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.report.ReportingService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.factory.AccountFactory;

public class BankingFactory implements AccountFactory {
    @Override
    public AccountDao getAccountDao() {
        return FileMemoryAccountDao.getInstance("Banking");
    }

    @Override
    public ReportingService getReportService() {
        return new BankingReportService();
    }

}
