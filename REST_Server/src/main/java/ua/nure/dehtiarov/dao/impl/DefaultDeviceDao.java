package ua.nure.dehtiarov.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.dao.DeviceDAO;
import ua.nure.dehtiarov.entity.Device;
import ua.nure.dehtiarov.entity.Outlet;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Repository
@Transactional
public class DefaultDeviceDao extends GenericDAOImpl<Device, Long> implements DeviceDAO {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Device> getAllDevicesByUserId(Long id) {
        Criteria criteria = getSession().createCriteria(Device.class);
        criteria.add(eq("user_id", id));

        return criteria.list();
    }

}
