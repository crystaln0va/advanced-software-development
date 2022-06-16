package edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Transaction;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyChanges(Transaction transaction, Account account);
}
