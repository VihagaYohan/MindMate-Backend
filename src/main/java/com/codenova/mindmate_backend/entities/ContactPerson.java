package com.codenova.mindmate_backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contact_persons")
public class ContactPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

/*
    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private User user;
*/

    //@OneToOne(mappedBy = "contactPerson")
    //@JoinColumn(name="user_id", referencedColumnName = "id", unique = true)
    //private Profile profile;

    @OneToOne
    @JoinColumn(name="id")
    @MapsId
    private Profile profile;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="mobile_number")
    private String mobileNumber;

/*    @OneToOne(mappedBy = "contactPerson")
    private Profile profile;*/

    @Column(name="is_active")
    private boolean isActive;
}
