package com.codenova.mindmate_backend.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="birth_date")
    private String birthDate;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;

    @Column(name="is_active")
    private Boolean isActive;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="profile_image_url")
    private String profileImageUrl;

    public String generateFullName() {
        return lastName + ", " + firstName;
    }

    public String generateAvatarLetters() {
        if(firstName != null && lastName != null) {
            return getFirstCharacter(this.firstName) + getFirstCharacter(this.lastName);
        } else if (firstName != null && lastName == null) {
            return getFirstCharacter(firstName);
        } else {
            return getFirstCharacter(lastName);
        }
    }

    public String getFirstCharacter(String input) {
        return input.substring(0,1).toUpperCase();
    }
}
