package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;

public class PersonalBankingNotifier implements Rule {

    @Override
    public boolean isNotify(Transaction transaction, boolean isApproved) {
        double amount = transaction.getAmount();
        if (amount > 500 && isApproved)
            return true;
        return false;
    }
}
