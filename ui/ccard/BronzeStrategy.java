package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class BronzeStrategy implements InterestStrategy {
    @Override
    public double getInterestPercentage() {
        return 0.1;
    }

    @Override
    public double calculateInterest(double balance) {
        return   balance *getInterestPercentage();
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0.14;
    }
}
