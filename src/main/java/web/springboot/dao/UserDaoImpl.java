package web.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.springboot.model.User;
import web.springboot.repository.UserRepository;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return this.userRepository.getOne(id);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
