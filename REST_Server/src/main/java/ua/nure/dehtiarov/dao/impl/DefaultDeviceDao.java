package ua.nure.dehtiarov.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.dao.DeviceDAO;
import ua.nure.dehtiarov.entity.Device;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Repository
@Transactional
public class DefaultDeviceDao extends GenericDAOImpl<Device, String> implements DeviceDAO {

    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
