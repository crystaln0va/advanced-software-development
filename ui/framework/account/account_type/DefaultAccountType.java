package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type;


public class DefaultAccountType implements AccountTypeOld {

    @Override
    public double getDepositAmount(double balance) {
        return balance;
    }
}
