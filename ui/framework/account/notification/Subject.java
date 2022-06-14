package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyChanges(double amount);
}
