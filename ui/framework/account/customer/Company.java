package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer;

public class Company extends Client{
    private Integer noEmployees;

    public Company(String name, Address address, String email, Integer noEmployees) {
        super(name, address, email);
        this.noEmployees = noEmployees;
    }
}
