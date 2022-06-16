package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.report.ReportingService;

import java.util.List;

public class BankingReportService extends ReportingService {
    
    @Override
    public String getReport(List<Account> allAccounts) {
        StringBuilder report = new StringBuilder();
        for(Account account: allAccounts){
            report.append("Account Number: ")
                    .append(account.getAccountNumber())
                    .append(" | Balance: ")
                    .append(account.getBalance());
        }
        return report.toString();
    }
}
