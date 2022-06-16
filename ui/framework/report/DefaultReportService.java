package edu.mum.cs.cs525.labs.exercises.project.ui.framework.report;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Account;

import java.util.List;

public class DefaultReportService extends ReportingService{
    @Override
    protected String getReport(List<Account> allAccounts) {
        return "Default Report Impl... This is empty";
    }
}
