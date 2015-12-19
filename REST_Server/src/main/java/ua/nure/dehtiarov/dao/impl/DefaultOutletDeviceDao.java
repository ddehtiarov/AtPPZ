package ua.nure.dehtiarov.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.dao.OutletDeviceDAO;
import ua.nure.dehtiarov.entity.OutletDevice;
import ua.nure.dehtiarov.entity.User;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Repository
@Transactional
public class DefaultOutletDeviceDao extends GenericDAOImpl<OutletDevice, Long> implements OutletDeviceDAO {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<OutletDevice> getAllOutletsByOutletId(Long id) {
        Criteria criteria = getSession().createCriteria(OutletDevice.class);
        criteria.add(eq("outlet_id", id));

        return criteria.list();
    }
}
