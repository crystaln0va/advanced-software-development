package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

import java.time.LocalDate;

public class Notifier implements Observer{
    private Rule rules;

    public Notifier(Rule rules){
        this.rules = rules;
    }

    @Override
    public void update(Transaction transaction, boolean isApproved) {
        if (rules.isNotify(transaction, isApproved)){
            // send a notification
            double amount = transaction.getAmount();
            LocalDate date = transaction.getDate();
            String description = transaction.getDescription();

            StringBuilder sb = new StringBuilder();
            sb.append("------------ transaction report -----------\n");
            sb.append("Date " + date + "\n");
            sb.append("amount " + amount + "\n");
            sb.append("Description " + description + "\n");
            sb.toString();
            System.out.println(sb);

        }
    }
}
