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
import ua.nure.dehtiarov.dao.UserDAO;
import ua.nure.dehtiarov.dao.impl.DefaultUserDao;
import ua.nure.dehtiarov.entity.User;
import ua.nure.dehtiarov.service.UserService;
import ua.nure.dehtiarov.service.impl.DefaultUserService;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DBConfig {


    @Inject
    private Environment environment;

//    @Value("classpath:schema-userrole.sql")
//    private Resource schemaScript;

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.hbm2ddl.auto",
                environment.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
//        final DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }

//    private DatabasePopulator databasePopulator() {
//        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(schemaScript);
//        return populator;
//    }

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
        localSessionFactoryBuilder.addAnnotatedClasses(new Class[]{User.class});
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

//    @Autowired
//    @Bean(name = "transactionManager")
////    @Scope(WebApplicationContext.SCOPE_REQUEST)
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory);
//        return hibernateTransactionManager;
//    }


    @Bean(name = "userDao")
    public UserDAO getUserDao() {
        return new DefaultUserDao();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new DefaultUserService();
    }

}


