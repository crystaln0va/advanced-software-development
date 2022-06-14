package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.impl.banking_account;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class CheckingAccountStrategy implements InterestStrategy {
    final double LESS_THAN_1000_RATE = 0.015;
    final double MORE_THAN_OR_EQUAL_1000_RATE = 0.025;
    @Override
    public double getInterestPercentage() {
        return 0.08;
    }

    @Override
    public double calculateInterest(double balance) {
        if(balance < 0) return 0;
        return balance * (balance < 1000 ? LESS_THAN_1000_RATE : MORE_THAN_OR_EQUAL_1000_RATE);

    }

    @Override
    public double minimumPaymentPercentage() {
        return 0;
    }
}


