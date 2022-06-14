package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class CreditCardNotifier implements Rule {
    @Override
    public boolean isNotify(Transaction transaction, boolean isApproved) {

        double amount = transaction.getAmount();
        if (amount > 400 && isApproved)
            return true;
        return false;
    }
}
