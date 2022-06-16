package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Rule;

import java.util.List;

public class DefaultAccountType implements AccountTypeStrategy{
    @Override
    public String getAccountTypeName() {
        return "Default Account Type";
    }

    @Override
    public <T> List<Rule<T>> getNotificationRules() {
        return List.of();
    }
}
