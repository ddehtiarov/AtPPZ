package ua.nure.dehtiarov.dao;

import ua.nure.dehtiarov.entity.User;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface UserDAO extends GenericDAO<User, Long> {

    Boolean authenticate(String email, String password);

    User findByEmail(String email);

    boolean addUser(User user);
}
