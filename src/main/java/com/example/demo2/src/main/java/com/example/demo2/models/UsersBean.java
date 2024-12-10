package com.example.demo2.models;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class UsersBean {

    @Inject
    private UserDAO dao;
    private int userId;
    private User user = new User();
    private List<User> users;
    private String searchName;
    private int maxResults;
    private List<String> strings;

    public void createUser() {
        dao.create(user);
        user = new User();
        loadUsers();
    }
    public void searchUsers() {
        users = dao.findUsersByName(searchName);
    }

    public void searchConcat() {
        strings = dao.getConcat(searchName);
    }
    public void findMaxResults() {
        users = dao.getMaxResults(maxResults);
    }
    public void deleteUser(int id) {
        dao.delete(id);
        loadUsers();
    }
    public void updateUser() {
        if (user.getId() != 0) {
            dao.update(user);
        } else {
            dao.create(user);
        }
        user = new User();
        loadUsers();
    }

    public String loadUser(User user) {
        this.user = user;
        return "Edit.xhtml";
    }
    public List<User> getUsers() {
        if (users == null) {
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        users = dao.findAllUsers();
    }

    public User getUser() {
        return user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}