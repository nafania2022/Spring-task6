package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import web.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;


@Service
@Transactional()
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }

    public void remove(long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public User getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
        return  user;
    }

    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
