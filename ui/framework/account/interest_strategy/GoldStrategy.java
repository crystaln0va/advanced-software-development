package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy;

public class GoldStrategy implements InterestStrategy {
    @Override
    public double getInterestPercentage() {
        return 0.06;
    }

    @Override
    public double calculateInterest(double balance) {
        return 0;
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0.10;
    }
}
