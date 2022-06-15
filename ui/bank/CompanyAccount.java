package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;

public class CompanyAccount implements AccountTypeStrategy {
    @Override
    public String getAccountTypeName() {
        return "Company";
    }
}
