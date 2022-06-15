package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer;

public class Personal extends Client{
    private String birthdate;

    public Personal(String name, Address address, String email, String birthdate) {
        super(name, address, email);
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Personal{" +
                super.toString()+
                "birthdate='" + birthdate + '\'' +
                '}';
    }
}
