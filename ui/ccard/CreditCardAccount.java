package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Rule;

import java.util.List;

public class CreditCardAccount implements AccountTypeStrategy {
    @Override

    public String getAccountTypeName() {
        return "Credit";
    }
    public List<Rule<Transaction>> getNotificationRules() {
        return List.of(new CreditCardNotifierRule());

    }
}
