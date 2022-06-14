package edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern;

public class Logger implements Observer {
    private Subject subject;
    private double balance = 0;

    public Logger(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(double balance) {
        this.balance = balance;
        System.out.println("adding  log :" + balance);

    }

}
