package ua.nure.dehtiarov.repository;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import ua.nure.dehtiarov.entity.Statistic;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface StatisticDAO extends GenericDAO<Statistic, Long>{

    List<Statistic> getAllStatisticsByUserId(Long id);

    List<Statistic> getAllStatisticsByOutletDeviceId(Long id);
}
