package service.impl;

import service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static UserService userService;

    public static UserService getInstance(){
        if(userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public void registerUser(String username, String email) {

    }
}
