package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.Transaction;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Rule;

public class CreditCardNotifierRule implements Rule<Transaction> {
    @Override
    public boolean isSatisfied(Transaction object) {
        return object != null && object.getAmount() > 400;
    }
}
