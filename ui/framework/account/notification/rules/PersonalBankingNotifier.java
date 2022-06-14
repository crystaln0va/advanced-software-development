package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.notification.rules;

public class PersonalBankingNotifier implements Rule {

    @Override
    public boolean isNotify(double amount, boolean isApproved) {
        if (amount > 500 && isApproved)
            return true;
        return false;
    }
}
