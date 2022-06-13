package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy;

import java.util.function.Predicate;

public interface InterestStrategy {
    double getMinimumPayment(double balance);
}
