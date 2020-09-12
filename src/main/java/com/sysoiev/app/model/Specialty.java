package com.sysoiev.app.model;

public class Specialty {
    private Long customerId;
    private Long id;
    private String specialty;

    public Specialty() {
    }

    public Specialty(Long customerId, Long id) {
        this.customerId = customerId;
        this.id = id;
    }

    public Specialty(Long id) {
        this.id = id;
    }

    public Specialty(Long id, String specialty) {
        this.id = id;
        this.specialty = specialty;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return id + " " + specialty;
    }
}