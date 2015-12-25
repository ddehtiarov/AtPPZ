package ua.nure.dehtiarov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.dehtiarov.dao.OutletDAO;
import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.service.OutletService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Service
@Transactional
public class DefaultOutletService implements OutletService {

    @Autowired
    OutletDAO outletDAO;

    @Override
    public void add(Outlet outlet) {
        outletDAO.save(outlet);
    }

    @Override
    public void update(Outlet outlet) {
        outletDAO.save(outlet);
    }

    @Override
    public void delete(Outlet outlet) {
        outletDAO.remove(outlet);
    }

    @Override
    public Outlet findOutletById(Long id) {
        return outletDAO.find(id);
    }

    @Override
    public Outlet findOutletByCode(String code) {
        return outletDAO.findOutletByCode(code);
    }

    @Override
    public List<Outlet> getAllOutletsByUserId(Long id) {
        return outletDAO.getAllOutletsByUserId(id);
    }
}
