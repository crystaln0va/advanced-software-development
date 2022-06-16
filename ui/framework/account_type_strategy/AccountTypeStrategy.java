package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.notification.Rule;

import java.io.Serializable;
import java.util.List;

public interface  AccountTypeStrategy extends Serializable {

    public String getAccountTypeName() ;

    <T> List<Rule<T>> getNotificationRules();

}
