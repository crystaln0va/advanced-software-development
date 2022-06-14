package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

public interface Rule {
    boolean isNotify(Transaction transaction, boolean isApproved);

}
