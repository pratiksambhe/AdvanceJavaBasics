package com.example.AUg5_SpringProject.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlFactoryBeans"
        ,transactionManagerRef = "mysqlTransactionManager"
        ,basePackages = "com.example.AUg5_SpringProject.repoMysql"
)
public class MysqlConfig {

    @Bean
    @ConfigurationProperties("spring.mysql.datasource")
    public DataSourceProperties mysqlDataSourceProperties(){
        return  new DataSourceProperties();
    }

    @Bean
    public DataSource mysqlDataSource(@Qualifier("mysqlDataSourceProperties") DataSourceProperties dataSourceProperties){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter mysqlJpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlFactoryBeans(@Qualifier("mysqlDataSource") DataSource  dataSource,@Qualifier("mysqlJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.AUg5_SpringProject.entityMysql");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        return localContainerEntityManagerFactoryBean;

    }

    @Bean
    public PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlFactoryBeans") LocalContainerEntityManagerFactoryBean factoryBean){
        assert factoryBean.getObject()!=null;
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
