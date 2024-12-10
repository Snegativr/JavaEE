package com.example.demo2.models;

import com.example.demo2.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(User user) {
        entityManager.persist(user);
    }

    public User read(int id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(int id) {
        User user = read(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public List<User> findAllUsers() {
        entityManager.createNativeQuery("USE LR6").executeUpdate();

        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }
}