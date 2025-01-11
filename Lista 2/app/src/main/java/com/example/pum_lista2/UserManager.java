package com.example.pum_lista2;
import java.util.ArrayList;
import java.util.List;
public class UserManager {
    private static UserManager instance;
    private List<User> users;

    private UserManager() {
        users = new ArrayList<>();
        // Dodaj pięciu domyślnych użytkowników
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
        users.add(new User("user5", "password5"));
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public boolean addUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Użytkownik już istnieje
            }
        }
        users.add(new User(username, password));
        return true;
    }

    public boolean validateLogin(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

