package web.service;

import web.models.User;

import java.util.List;
public interface UserService {
    void add(User user);
    void remove(long id);
    void update(User user);
    User getUser(long id);
    List<User> listAllUser();
}
