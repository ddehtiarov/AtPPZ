package ua.nure.dehtiarov.repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.dehtiarov.entity.Outlet;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface OutletDAO extends GenericDAO<Outlet, Long> {

    List<Outlet> getAllOutletsByUserId(Long id);

    Outlet findOutletByCode(String code);
}
