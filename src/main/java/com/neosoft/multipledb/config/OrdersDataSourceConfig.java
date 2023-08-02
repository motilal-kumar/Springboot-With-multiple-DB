package com.neosoft.multipledb.config;


import java.util.Properties;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


/**
 * OrdersDataSourceConfig.
 *
 * @author Motilal  Kumar.
 *  version 1.0
 *
 */


@Configuration
@EnableJpaRepositories(
        basePackages = "com.neosoft.multipledb.orders.repositories",
        entityManagerFactoryRef = "ordersEntityManagerFactory",
        transactionManagerRef = "ordersTransactionManager"
)
public class OrdersDataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "datasource.orders")
    public DataSourceProperties ordersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource ordersDataSource() {
        DataSourceProperties primaryDataSourceProperties = ordersDataSourceProperties();
        return DataSourceBuilder.create()
                .driverClassName(primaryDataSourceProperties.getDriverClassName())
                .url(primaryDataSourceProperties.getUrl())
                .username(primaryDataSourceProperties.getUsername())
                .password(primaryDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager ordersTransactionManager() {
        EntityManagerFactory factory = ordersEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean ordersEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ordersDataSource());
        factory.setPackagesToScan(new String[] {
                "com.neosoft.multipledb.orders.entities"
        });
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", environment.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);

        return factory;

    }

    @Bean
    public DataSourceInitializer ordersDataSourceInitializer() {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(ordersDataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("orders-data.sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(environment.getProperty("datasource.orders.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }

}
