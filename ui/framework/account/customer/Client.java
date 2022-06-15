package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer;


import java.io.Serial;
import java.io.Serializable;

public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 20220615L;

    private final String name;
    private final Address address;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    private final String email;

    public Client(String name, Address address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
//    public String getExpireDate() {
//      return "";
//    }
//
//    public Integer getNoEmployees() {
//        return 0;
//    }
//    public String getBirthdate() {
//        return "";
//    }
}
