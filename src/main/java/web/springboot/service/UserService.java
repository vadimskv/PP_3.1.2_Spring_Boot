package web.springboot.service;

import web.springboot.model.User;

import java.util.List;

public interface UserService {
    public User findById(Long id);

    public List<User> findAll();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Long id);
}
