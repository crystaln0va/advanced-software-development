package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

public interface Rule {
    boolean isNotify(double amount, boolean isApproved);

}
