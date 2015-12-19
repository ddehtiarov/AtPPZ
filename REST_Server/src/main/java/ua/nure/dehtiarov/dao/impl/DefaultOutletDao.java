package ua.nure.dehtiarov.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.dao.OutletDAO;
import ua.nure.dehtiarov.entity.Outlet;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Repository
@Transactional
public class DefaultOutletDao extends GenericDAOImpl<Outlet, Long> implements OutletDAO {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Outlet> getAllOutletsByUserId(Long id) {
        Criteria criteria = getSession().createCriteria(Outlet.class);
        criteria.add(eq("user_id", id));

        return criteria.list();
    }
}
