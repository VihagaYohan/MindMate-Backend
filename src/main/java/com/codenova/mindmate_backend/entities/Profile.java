package com.codenova.mindmate_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name="id")
    @MapsId
    private User user;

    @OneToOne(mappedBy = "profile")
    // @JoinColumn(name="id")
    // @MapsId
    private ContactPerson contactPerson;

/*    @OneToOne
    @JoinColumn(name="contact_person_id")
    private ContactPerson contactPerson;*/

   @Column(name="is_active")
   private Boolean isActive;

    @Column(name="created_at", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    // automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
