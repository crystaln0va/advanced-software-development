package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy;

public class GoldStrategy implements InterestStrategy {
    private static final double MP = 0.10;

    @Override
    public double getMinimumPayment(double balance) {
        return balance * MP;
    }
}
