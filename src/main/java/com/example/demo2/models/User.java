package com.example.demo2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT s FROM User s"),
        @NamedQuery(name = "User.findByName", query = "SELECT s FROM User s WHERE s.name = :name")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String passwd;

    // Геттери та сеттери
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}