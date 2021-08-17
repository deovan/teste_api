package br.com.model;

public class GeradorDeMassa {

   public GeradorDeMassa() {
        getCustomer();
    }

    private static Customer customer;

    public static Customer getNewCustomer() {
        return new Customer();
    }

    public static Customer getCustomer() {
        if (customer == null) {
            customer = getNewCustomer();
        }
        return customer;
    }

}