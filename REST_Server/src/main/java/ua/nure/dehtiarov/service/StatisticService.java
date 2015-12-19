package ua.nure.dehtiarov.service;

import ua.nure.dehtiarov.entity.Outlet;
import ua.nure.dehtiarov.entity.Statistic;

import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
public interface StatisticService {

    void add(Statistic statistic);

    void update(Statistic statistic);

    void delete(Statistic statistic);

    Outlet findStatisticById(Long id);

    List<Statistic> getAllStatisticsByUserId();

    List<Statistic> getAllStatisticsByOutletDeviceId();

}
