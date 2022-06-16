package edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy;

public class DefaultInterestStrategy implements InterestStrategy {

    @Override
    public double getInterestPercentage() {
        return 0;
    }

    @Override
    public double calculateInterest(double balance) {

        return 0;
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0;
    }

    @Override
    public String getStrategyType() {
        return "Default";
    }
}
