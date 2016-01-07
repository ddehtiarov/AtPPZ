package ua.nure.dehtiarov.repository.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.dehtiarov.repository.DeviceDAO;
import ua.nure.dehtiarov.entity.Device;

import java.util.ArrayList;
import java.util.List;

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
        List<Device> devices = findAll();
        List<Device> deviceArrayList = new ArrayList<>();

        for (Device outlet : devices) {
            if (outlet.getUser().getId().equals(id)) {
                deviceArrayList.add(outlet);
            }
        }
        return deviceArrayList;
    }

}
