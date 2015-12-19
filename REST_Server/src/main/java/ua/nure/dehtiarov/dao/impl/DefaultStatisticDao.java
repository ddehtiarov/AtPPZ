package ua.nure.dehtiarov.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.dao.StatisticDAO;
import ua.nure.dehtiarov.entity.Statistic;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;
/**
 * Created by dehtiarov on 12/19/2015.
 */
@Repository
@Transactional
public class DefaultStatisticDao extends GenericDAOImpl<Statistic, Long> implements StatisticDAO {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Statistic> getAllStatisticsByUserId(Long id) {
        Criteria criteria = getSession().createCriteria(Statistic.class);
        criteria.add(eq("user_id", id));

        return criteria.list();
    }

    @Override
    public List<Statistic> getAllStatisticsByOutletDeviceId(Long id) {
        Criteria criteria = getSession().createCriteria(Statistic.class);
        criteria.add(eq("outletDevice_id", id));

        return criteria.list();
    }
}
