package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer;

public class PersonalClient extends Client{
    private String birthdate;

    public PersonalClient(String name, Address address, String email, String birthdate) {
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

    public String getBirthdate() {
        return birthdate;
    }
}
