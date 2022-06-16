package edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Transaction;

public interface Observer {
    void update(Transaction transaction, Account account);
}
