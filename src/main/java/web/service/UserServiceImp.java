package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.models.User;
import web.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements web.service.UserService {

    private  UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void add(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void update(User user) {
        userRepository.save(user);

    }

    @Override
    @Transactional
    public User getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
        return  user;
    }

    @Override
    public List<User> listAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
