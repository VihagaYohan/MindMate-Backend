package com.codenova.mindmate_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToOne
    @JoinColumn(name="id")
    @MapsId
    private Profile profile;

    @OneToOne
    @JoinColumn(name="id")
    @MapsId
    private ContactPerson contactPerson;

}
