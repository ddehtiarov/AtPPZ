package ua.nure.dehtiarov.service;

import ua.nure.dehtiarov.entity.Outlet;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface OutletService {

    void add(Outlet outlet);

    void update(Outlet outlet);

    void delete(Outlet outlet);

    Outlet findOutletById(Long id);

    List<Outlet> getAllOtletssByUserId();

}
