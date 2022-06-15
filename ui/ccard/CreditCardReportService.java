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
        double less;
        double more;
        double netBalance;
        double chargesSum;
        double paymentsSum;
        double newBalance;
        double totalDue;
        InterestStrategy interestPercent;
        String summary = "";

        // Net balance last month
        for (Account a : allAccounts) {
            less=0;
            more=0;
            netBalance=0;
            chargesSum=0;
            paymentsSum=0;
            newBalance=0;
            totalDue=0;
        
            try {
                AccountImpl impl = (AccountImpl) a;
                interestPercent = impl.getInterestStrategy();
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
                        less += t.getAmount();
                    } else if (t.getDescription().equalsIgnoreCase("deposit")) {
                        more += t.getAmount();
                    }
                    
                }
                netBalance = more - less;


                
                for (Transaction t : currentMonthTransactions) {
                    // Total withdrawals / charges this month
                    if (t.getDescription().equalsIgnoreCase("withdrawal")) {
                        chargesSum += t.getAmount();
                    // Total deposits / payments this month
                    } else if (t.getDescription().equalsIgnoreCase("deposit")) {
                        paymentsSum += t.getAmount();
                    }
                }
                
                newBalance = netBalance - paymentsSum + chargesSum + interestPercent.getInterestPercentage() * (netBalance - paymentsSum);
                totalDue = interestPercent.minimumPaymentPercentage() * newBalance;
                
                

            } catch (Exception e) {
                System.out.println("Unimplemented account");
                e.printStackTrace();
            }

            summary +=   "Previous month balance: " + netBalance +
                        "\nTotal charges this month: " + chargesSum +
                        "\nTotal payments this month: " + paymentsSum +
                        "\nNew balance: " + newBalance +
                        "\nTotal due: " + totalDue +
                        "\n";
        }
        
        return summary;
    }

    public static void main(String[] args) {
        AccountService service1 = new AccountServiceImpl(new BankingFactory());
        service1.createNewAccount("123",new CreditCardAccount(),new BronzeStrategy());
        service1.deposit("123",450);
        service1.deposit("123",550);
        service1.deposit("123",1000);
        service1.withdraw("123",10);
        service1.withdraw("123",30);
        service1.withdraw("123",60);
        System.out.println(service1.getReport());
    }

}