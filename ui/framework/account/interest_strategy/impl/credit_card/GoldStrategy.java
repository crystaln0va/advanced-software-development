package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.credit_card;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class GoldStrategy implements InterestStrategy {
    @Override
    public double getInterestPercentage() {
        return 0.06;
    }

    @Override
    public double calculateInterest(double balance) {
        return    balance * 0.6;
    }

    @Override
    public double minimumPaymentPercentage() {
        return 0.10;
    }
}
