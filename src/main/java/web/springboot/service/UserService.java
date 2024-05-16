package web.springboot.service;

import web.springboot.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
