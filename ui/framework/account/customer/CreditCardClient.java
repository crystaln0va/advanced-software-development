package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer;

public class CreditCardClient extends Client{
    private String expireDate;
    public CreditCardClient(String name, Address address, String email,String expireDate) {
        super(name, address, email);
        this.expireDate = expireDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return "CreditCardClient{" +
                super.toString()+
                "expireDate='" + expireDate + '\'' +
                '}';
    }
}
