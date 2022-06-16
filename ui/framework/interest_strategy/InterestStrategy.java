package edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy;


import java.io.Serializable;

public interface InterestStrategy extends Serializable {
    double getInterestPercentage();
    double calculateInterest(double balance);

    double minimumPaymentPercentage();
     String getStrategyType() ;
}
