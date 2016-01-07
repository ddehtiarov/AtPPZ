package ua.nure.dehtiarov.repository.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.repository.OutletDAO;
import ua.nure.dehtiarov.entity.Outlet;

import java.util.ArrayList;
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
        List<Outlet> outlets = findAll();
        List<Outlet> resOutlets = new ArrayList<>();

        for (Outlet outlet : outlets) {
            if (outlet.getUser().getId().equals(id)) {
                resOutlets.add(outlet);
            }
        }

        return resOutlets;
    }

    @Override
    public Outlet findOutletByCode(String code) {
        Criteria criteria = getSession().createCriteria(Outlet.class);
        criteria.add(eq("serialCode", code));

        return (Outlet) criteria.uniqueResult();
    }
}
