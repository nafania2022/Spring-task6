//package web.dao;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import web.models.User;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//@Component
//public class UserDaoImp implements UserDao {
//
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    UserDaoImp(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    public void remove(long id) {
//        User user = sessionFactory.getCurrentSession().get(User.class, id);
//        sessionFactory.getCurrentSession().remove(user);
//
//    }
//
//    @Override
//    public void update(User user) {
//        sessionFactory.getCurrentSession().update(user);
//
//    }
//
//
//    @Override
//    public User getUser(long id) {
//        User user = sessionFactory.getCurrentSession().get(User.class, id);
//        return user;
//    }
//
//
//    @Override
//    @Transactional
//    public List<User> listAllUser() {
//        List<User> users = sessionFactory.getCurrentSession()
//                .createQuery("from User ")
//                .getResultList();
//        return users;
//    }
//}
