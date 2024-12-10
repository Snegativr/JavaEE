package com.example.demo2.models;

import com.example.demo2.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

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

    public List<User> findUsersByName(String name) {
        String pattern = name + '%';
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", pattern);
        return query.getResultList();
    }
    public List<User> getMaxResults(int count) {
        return entityManager.createNamedQuery("User.findAll", User.class)
                .setMaxResults(count)
                .getResultList();
    }
    public List<String> getConcat(String name) {
        return entityManager.createQuery(
                "select CONCAT(lower( u.name) ,'   ', upper(u.email), '   ', u.passwd) from User u"
                        , String.class)
                .getResultList();
    }
}