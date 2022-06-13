package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy;

public class DefaultInterestStrategy implements InterestStrategy {

    @Override
    public double getMinimumPayment(double balance) {
        return 0;
    }
}
