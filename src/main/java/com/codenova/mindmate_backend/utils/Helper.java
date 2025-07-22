package com.codenova.mindmate_backend.utils;

public class Helper {
    // return full name
    public String generateFullName(
            String firstName,
            String lastName
    ) {
        return lastName + ", " + firstName;
    }

    // get first letters from name for avatar
    public String generateAvatarLetters(
            String firstName,
            String lastName
    ) {
        if(firstName != null && lastName != null) {
            return getFirstCharacter(firstName) + getFirstCharacter(lastName);
        } else if(firstName != null && lastName == null) {
            return getFirstCharacter(firstName);
        } else {
            return getFirstCharacter(lastName);
        }
    }

    // return first letter of a string
    public String getFirstCharacter(String input) {
        return input.substring(0,1).toUpperCase();
    }
}
