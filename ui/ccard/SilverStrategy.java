package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;

public class SilverStrategy implements InterestStrategy {
    @Override
    public double getInterestPercentage() {
        return 0.08;
    }

    @Override
    public double calculateInterest(double balance) {
        return   balance *getInterestPercentage();
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0.12;
    }

    @Override
    public String getStrategyType() {
        return "Silver";
    }
}
