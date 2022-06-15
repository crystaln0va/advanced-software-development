package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

import java.util.List;

public class CompanyAccount implements AccountTypeStrategy {
    @Override
    public List<Rule<Transaction>> getNotificationRules() {
        return List.of(new CompanyBankingNotifierRule());
    }
}
