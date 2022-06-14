package edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
