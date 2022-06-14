package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class SavingAccountStrategy implements InterestStrategy {
    final double LESS_THAN_1000_RATE = 0.01;
    final double BETWEEN_1000_AND_5000_RATE = 0.02;
    final double MORE_THAN_OR_EQUAL_5000_RATE = 0.04;
    @Override
    public double getInterestPercentage() {
        return 0.08;
    }

    @Override
    public double calculateInterest(double balance) {
        if(balance <0) return 0;

        double interest = 0;

        if(balance < 1000)
            interest = balance * LESS_THAN_1000_RATE;
        else if(balance >= 1000 && balance < 5000)
            interest = balance * BETWEEN_1000_AND_5000_RATE;
        else
            interest = balance * MORE_THAN_OR_EQUAL_5000_RATE;

        return interest;

    }

    @Override
    public double minimumPaymentPercentage() {
        return 0;
    }
}
