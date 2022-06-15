package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.bank.BankingFactory;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.*;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CreditCardReportService implements ReportingService {
    @Override
    public String getReport(List<Account> allAccounts) {
        List<Transaction> previousMonthTransactions = new ArrayList<Transaction>();
        List<Transaction> currentMonthTransactions = new ArrayList<Transaction>();
        LocalDate lt = LocalDate.now();
        double withdrawalSumLastMonth;
        double depositSumLastMonth;
        double balanceLastMonth;
        double withdrawalSumThisMonth;
        double depositSumThisMonth;
        double newBalance;
        double totalDue;
        InterestStrategy percentFinder;
        String summary = "";

        for (Account a : allAccounts) {
            withdrawalSumLastMonth=0;
            depositSumLastMonth=0;
            withdrawalSumThisMonth=0;
            depositSumThisMonth=0;
            newBalance=0;
            totalDue=0;
            balanceLastMonth=0;
        
            try {
                AccountImpl impl = (AccountImpl) a;
                percentFinder = impl.getInterestStrategy();
                List<Transaction> allTransactions = impl.getTransactions();

                for (Transaction t : allTransactions) {
                    if (t.getDate().getMonthValue() == lt.getMonthValue()-1) {  // last month
                        previousMonthTransactions.add(t);
                    } else if (t.getDate().getMonthValue() == lt.getMonthValue()) {     // this month
                        currentMonthTransactions.add(t);
                    }
                }

                for (Transaction t : previousMonthTransactions) {
                    if (t.getDescription().equalsIgnoreCase("withdrawal")) {
                        withdrawalSumLastMonth += t.getAmount();
                    } else if (t.getDescription().equalsIgnoreCase("deposit")) {
                        depositSumLastMonth += t.getAmount();
                    }
                }

                for (Transaction t : currentMonthTransactions) {
                    // Total withdrawals / charges this month
                    if (t.getDescription().equalsIgnoreCase("withdrawal")) {
                        withdrawalSumThisMonth += t.getAmount();
                    // Total deposits / payments this month
                    } else if (t.getDescription().equalsIgnoreCase("deposit")) {
                        depositSumThisMonth += t.getAmount();
                    }
                }
                // Balance from last month
                balanceLastMonth =  a.getBalance() + depositSumThisMonth - withdrawalSumThisMonth +
                                    depositSumLastMonth - withdrawalSumLastMonth;

                newBalance = balanceLastMonth - depositSumThisMonth + withdrawalSumThisMonth + percentFinder.getInterestPercentage() * (balanceLastMonth - depositSumThisMonth);
                totalDue = percentFinder.minimumPaymentPercentage() * newBalance;
            } catch (Exception e) {
                System.out.println("Unimplemented account");
                e.printStackTrace();
            }

            summary +=   "Previous month balance: " + balanceLastMonth +
                        "\nTotal charges this month: " + withdrawalSumThisMonth +
                        "\nTotal payments this month: " + depositSumThisMonth +
                        "\nNew balance: " + newBalance +
                        "\nTotal due: " + totalDue +
                        "\n";
        }
        return summary;
    }


}