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

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

   @OneToOne(mappedBy = "profile")
    private User user;

   @OneToOne
   @JoinColumn(name="id")
   @MapsId
   private ContactPerson contactPerson;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    // return full name
    public String generateFullName() {
        return lastName + ", " + firstName;
    }

    // generate letters for avatar
    public String generateAvatarLetters() {
        if(firstName != null && lastName != null) {
            return getFirstCharacter(this.firstName) + getFirstCharacter(this.lastName);
        } else if (firstName != null && lastName == null) {
            return getFirstCharacter(firstName);
        } else {
            return getFirstCharacter(lastName);
        }
    }

    // return first letter of name
    public String getFirstCharacter(String input) {
        return input.substring(0,1).toUpperCase();
    }
}
