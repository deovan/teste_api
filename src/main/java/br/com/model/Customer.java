package br.com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String name;
    private String lastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String fromEmployer;
    private String creditLimit;

    public Customer() {
        name = "Teste Sicredi";
        lastName = "Teste";
        contactFirstName = "Deovan";
        phone = "51 9999-9999";
        addressLine1 = "Av Assis Brasil, 3970";
        addressLine2 = "Torre D";
        city = "Porto Alegre";
        state = "RS";
        postalCode = "91000-000";
        country = "Brasil";
        fromEmployer = "Fixter";
        creditLimit = "200";
    }

}