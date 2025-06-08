package service;

import model.User;

public interface UserService {
    User registerUser(String username, String email);
}
