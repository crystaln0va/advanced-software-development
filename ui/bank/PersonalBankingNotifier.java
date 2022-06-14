package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.Rule;

public class PersonalBankingNotifier implements Rule {

    @Override
    public boolean isNotify(Transaction transaction, boolean isApproved) {
        double amount = transaction.getAmount();
        if (amount > 500 && isApproved)
            return true;
        return false;
    }
}
