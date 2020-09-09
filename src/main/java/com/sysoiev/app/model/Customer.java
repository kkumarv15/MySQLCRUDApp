package com.sysoiev.app.model;

import java.util.Set;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Account account;
    private Set<Specialty> specialties;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, String name, String surname, Set<Specialty> specialties, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpecialties(Specialty specialty) {
        specialties.add(specialty);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Account getAccount() {
        return account;
    }

    public String getSpecialties() {
        String specialtyString = "";
        for (Specialty s : specialties) {
            specialtyString += "{" + s.getId() + "}";
        }
        return specialtyString;
    }

    @Override
    public String toString() {
        return id + "/ " + name + "/ " + surname + "/ " + getSpecialties() + " /" + account.getId();
    }

   /* public static class CustomerBuilder {
        private Long id;
        private String name;
        private String surname;
        private Account account;
        private Set<Specialty> specialties;

        public CustomerBuilder() {
        }

        public CustomerBuilder(String name, String surname, Set<Specialty> specialties, Account account) {
            this.name = name;
            this.surname = surname;
            this.specialties = specialties;
            this.account = account;
        }

        public CustomerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Customer buildCustomer() {
            Customer customer = new Customer(this);
            return customer;
        }
    }*/
}