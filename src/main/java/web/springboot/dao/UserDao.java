package web.springboot.dao;

import web.springboot.model.User;

import java.util.List;

public interface UserDao {
    public User findById(Long id);

    public List<User> findAll();

    public User saveUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long id);

}
