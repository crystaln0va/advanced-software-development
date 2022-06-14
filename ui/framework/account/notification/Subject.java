package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyChanges(Transaction transaction, boolean isApproved);
}
