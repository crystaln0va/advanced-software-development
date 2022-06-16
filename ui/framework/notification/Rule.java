package edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification;

public interface Rule <T> {
    boolean isSatisfied(T object);
}
