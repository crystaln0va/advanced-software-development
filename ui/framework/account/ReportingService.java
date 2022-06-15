package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.util.List;

public interface ReportingService {
    String getReport(List<Account> allAccounts);
}