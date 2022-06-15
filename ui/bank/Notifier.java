package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Observer;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Notifier implements Observer {

    public Notifier(){
    }

    @Override
    public void update(Transaction transaction, Account account) {
        // TODO: How to implement pull instead of push
        List<Rule<Transaction>> rules = account.getAccountType().getNotificationRules();
        boolean rulesSatisfied = rules.stream().map(rule -> rule.isSatisfied(transaction)).reduce(true, (a, b) -> a && b);

        if (rulesSatisfied){
            if(transaction == null)
                sendDeclinedNotification();
            else
                sendNotificationDetails(transaction);
        }
    }

    private void sendNotificationDetails(Transaction transaction) {
        double amount = transaction.getAmount();
        LocalDate date = transaction.getDate();
        String description = transaction.getDescription();

        String sb = "------------ transaction report -----------\n" +
                "Date " + date + "\n" +
                "amount " + amount + "\n" +
                "Description " + description + "\n";
        System.out.println(sb);
    }

    private void sendDeclinedNotification() {
        System.out.println("---- Invalid Transaction ----");
    }
}
