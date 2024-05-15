package web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.springboot.dao.UserDao;
import web.springboot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
