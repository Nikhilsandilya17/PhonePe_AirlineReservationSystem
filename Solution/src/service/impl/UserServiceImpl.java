package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static UserService userService;

    public static UserService getInstance(){
        if(userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    private UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public User registerUser(String username, String email) {
        User user = new User(generateId(), username, email);
        userRepository.registerUser(user);
        return user;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
