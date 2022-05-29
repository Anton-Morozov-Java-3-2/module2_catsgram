package ru.yandex.practicum.catsgram.model;

import java.time.LocalDate;

public class User {

    private String email;
    private String nickname;
    private LocalDate birthdate;

    public User(String email, String nickname, LocalDate birthdate){
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }
    
    public String getNickname() {
        return nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}



