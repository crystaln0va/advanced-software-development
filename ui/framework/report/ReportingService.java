package edu.mum.cs.cs525.labs.exercises.project.ui.framework.report;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.dao.AccountDao;

import java.util.List;

public abstract class ReportingService {

    public final String generateReport(AccountDao accountDao){
        return "---------------------- " + reportHeader() + " ------------------------\n\n" +
                getReport(accountDao.getAllAccounts()) + "\n\n" +
                "---------------------- " + reportFooter() + " ------------------------";
    }

    public String reportHeader(){
        return "Default Generation Template";
    }

    public String reportFooter(){
        return "Default Generation Template";
    }

    protected abstract String getReport(List<Account> allAccounts);
}