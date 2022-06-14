package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

public class DefaultMinimumPaymentRule implements MinimumPaymentRule{
    @Override
    public double minimumPayment() {
        return 0.1;
    }
}
