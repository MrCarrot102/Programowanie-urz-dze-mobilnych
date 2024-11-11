package com.example.pum_lista2;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
        // Dodaj 5 przykładowych użytkowników
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
        users.add(new User("user5", "password5"));
    }

    public boolean addUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // użytkownik już istnieje
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
