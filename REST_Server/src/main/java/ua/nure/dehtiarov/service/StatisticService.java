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

    Statistic findStatisticById(Long id);

    List<Statistic> getAllStatisticsByUserId(Long id);

    List<Statistic> getAllStatisticsByOutletDeviceId(Long id);

}
