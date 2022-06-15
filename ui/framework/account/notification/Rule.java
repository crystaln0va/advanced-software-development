package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

import java.util.function.Predicate;

public interface Rule <T> {
    boolean isSatisfied(T object);
}
