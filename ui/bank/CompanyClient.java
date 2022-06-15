package edu.mum.cs.cs525.labs.exercises.project.ui.bank;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Address;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;

public class CompanyClient extends Client {
    private Integer noEmployees;

    public Integer getNoEmployees() {
        return noEmployees;
    }

    public CompanyClient(String name, Address address, String email, Integer noEmployees) {
        super(name, address, email);
        this.noEmployees = noEmployees;
    }
}
