package edu.mum.cs.cs525.labs.exercises.project.ui.framework.util;

public interface Subject {
    void subscribe();
    void unsubscribe();
    void notifyChanges();
}
