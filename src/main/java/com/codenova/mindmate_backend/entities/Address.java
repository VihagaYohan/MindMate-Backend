package com.codenova.mindmate_backend.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String streetName;
    private String houseNumber;
    private String zipCode;
}
