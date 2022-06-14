package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

public interface Observer {
    void update(Transaction transaction, boolean isApproved);
}
