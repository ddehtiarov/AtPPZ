package ua.nure.dehtiarov.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.WebApplicationContext;
import ua.nure.dehtiarov.dao.*;
import ua.nure.dehtiarov.dao.impl.*;
import ua.nure.dehtiarov.entity.*;
import ua.nure.dehtiarov.service.*;
import ua.nure.dehtiarov.service.impl.*;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig {

    @Inject
    private Environment environment;

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.hbm2ddl.auto",
                environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Autowired
    @Bean(name = "hibernateTemplate")
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(
                dataSource);
        localSessionFactoryBuilder.addAnnotatedClasses(new Class[]{Status.class, Device.class,
                Outlet.class, User.class, OutletDevice.class, Statistic.class});
        localSessionFactoryBuilder.addProperties(getHibernateProperties());
        localSessionFactoryBuilder.scanPackages("ua.nure.dehtiarov.entity");
        return localSessionFactoryBuilder.buildSessionFactory();
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("driverClassName"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username1"));
        dataSource.setPassword(environment.getProperty("password1"));
        return dataSource;
    }

    @Bean(name = "userDao")
    public UserDAO getUserDao() {
        return new DefaultUserDao();
    }

    @Bean(name = "statisticDAO")
    public StatisticDAO getStatisticDao() {
        return new DefaultStatisticDao();
    }

    @Bean(name = "deviceDAO")
    public DeviceDAO getDeviceDAO() {
        return new DefaultDeviceDao();
    }

    @Bean(name = "outletDAO")
    public OutletDAO getOutletDAO() {
        return new DefaultOutletDao();
    }

    @Bean(name = "outletDeviceDAO")
    public OutletDeviceDAO getOutletDeviceDAO() {
        return new DefaultOutletDeviceDao();
    }

    @Bean(name = "statusDAO")
    public StatusDAO getStatusDAO() {
        return new DefaultStatusDao();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new DefaultUserService();
    }

    @Bean(name = "outletService")
    public OutletService getOutletService() {
        return new DefaultOutletService();
    }

    @Bean(name = "deviceService")
    public DeviceService getDeviceService() {
        return new DefaultDeviceService();
    }

    @Bean(name = "statisticService")
    public StatisticService getStatisticService() {
        return new DefaultStatisticService();
    }

    @Bean(name = "outletDeviceService")
    public OutletDeviceService getOutletDeviceService() {
        return new DefaultOutletDeviceService();
    }

}


