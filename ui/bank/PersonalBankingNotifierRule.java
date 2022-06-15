package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

public class PersonalBankingNotifierRule implements Rule<Transaction> {
    @Override
    public boolean isSatisfied(Transaction object) {
        return object == null || object.getAmount() > 500;
    }
}
