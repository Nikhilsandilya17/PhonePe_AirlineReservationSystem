package repository.impl;

import model.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> userDatabase;

    public UserRepositoryImpl() {
        userDatabase = new HashMap<>();
    }

    @Override
    public void registerUser(User user) {
        System.out.println("Saving user: " + user.getName());
        userDatabase.put(user.getEmail(), user);
    }
}
