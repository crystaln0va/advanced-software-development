package edu.mum.cs.cs525.labs.exercises.project.ui.framework.factory;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.AccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.FileMemoryAccountDao;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.report.DefaultReportService;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.report.ReportingService;

public class DefaultFrameworkFactory implements AccountFactory {
    @Override
    public AccountDao getAccountDao() {
        return FileMemoryAccountDao.getInstance("DefaultDao");
    }

    @Override
    public ReportingService getReportService() {
        return new DefaultReportService();
    }
}
