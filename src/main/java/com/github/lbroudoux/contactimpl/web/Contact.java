package com.github.lbroudoux.contactimpl.web;

/**
 * @author laurent
 */
public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    private String iban;

    public Contact() {}

    public Contact(String firstname, String lastname, String email, String iban) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.iban = iban;
    }

    public String getFirstname() {
        return this.firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIban() {
        return this.iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
}