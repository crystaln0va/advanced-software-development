package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;

public class CreditCardAccount implements AccountTypeStrategy {
    @Override
    public String getAccountTypeName() {
        return "Credit";
    }
}
