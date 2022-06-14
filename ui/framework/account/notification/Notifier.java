package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class Notifier implements Observer{
    private Rule rules;

    public Notifier(Rule rules){
        this.rules = rules;
    }

    @Override
    public void update(double amount, boolean isApproved) {
        if (rules.isNotify(amount, isApproved)){
            // send a notification
        }
    }
}
