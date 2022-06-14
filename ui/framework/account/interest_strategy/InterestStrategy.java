package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy;


public interface InterestStrategy {
    double getInterestPercentage();
    double calculateInterest(double balance);

    double minimumPaymentPercentage();
}
