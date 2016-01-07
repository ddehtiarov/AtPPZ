package ua.nure.dehtiarov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.dehtiarov.repository.StatisticDAO;
import ua.nure.dehtiarov.entity.Statistic;
import ua.nure.dehtiarov.service.StatisticService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dehtiarov on 12/19/2015.
 */
@Service
@Transactional
public class DefaultStatisticService implements StatisticService {

    @Autowired
    StatisticDAO statisticDAO;

    @Override
    public void add(Statistic statistic) {
        statisticDAO.save(statistic);
    }

    @Override
    public void update(Statistic statistic) {
        statisticDAO.save(statistic);
    }

    @Override
    public void delete(Statistic statistic) {
        statisticDAO.remove(statistic);
    }

    @Override
    public Statistic findStatisticById(Long id) {
        return statisticDAO.find(id);
    }

    @Override
    public List<Statistic> getAllStatisticsByUserId(Long id) {
        return statisticDAO.getAllStatisticsByUserId(id);
    }

    @Override
    public List<Statistic> getAllStatisticsByOutletDeviceId(Long id) {
        return statisticDAO.getAllStatisticsByOutletDeviceId(id);
    }
}
