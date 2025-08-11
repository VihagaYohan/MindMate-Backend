package com.codenova.mindmate_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    // automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.isActive = true;
    }
}
