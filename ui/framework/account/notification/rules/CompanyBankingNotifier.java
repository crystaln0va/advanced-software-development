package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules.Rule;

public class CompanyBankingNotifier implements Rule {

    @Override
    public boolean isNotify(double amount, boolean isApproved) {
        if (amount > 0 && isApproved)
            return true;
        return false;
    }
}
