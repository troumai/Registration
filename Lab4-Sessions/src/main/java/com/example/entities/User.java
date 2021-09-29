package com.example.entities;

public class User {
    private String name;
    private String surname;
    private String group;
    private String email;
    private String password;
    public User() {
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    private String encodingCaesar(String word){
//        StringBuilder result = new StringBuilder();
//        for (char character : word.toCharArray()) {
//            if (character != ' ') {
//                int originalAlphabetPosition = character - 'a';
//                int newAlphabetPosition = (originalAlphabetPosition + 5) % 26;
//                char newCharacter = (char) ('a' + newAlphabetPosition);
//                result.append(newCharacter);
//            } else {
//                result.append(character);
//            }
//        }
//        return String.valueOf(result);
//    }
}
