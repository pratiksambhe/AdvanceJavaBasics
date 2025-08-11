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
        entityManagerFactoryRef = "oracleEntityFactory"
        ,transactionManagerRef = "oracleTransactionManager"
        ,basePackages = "com.example.AUg5_SpringProject.repoOracle"
)
public class OracleConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.oracle.datasource")
    public DataSourceProperties oracleDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oracleDataSource(@Qualifier("oracleDataSourceProperties") DataSourceProperties dataSourceProperties){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setUrl(dataSourceProperties.getUrl());
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter oracleJpaVendorAdapter(){
        HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean oracleEntityFactory(@Qualifier("oracleDataSource") DataSource dataSource,@Qualifier("oracleJpaVendorAdapter") JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.example.AUg5_SpringProject.entityOracle");
    return factoryBean;
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracleEntityFactory") LocalContainerEntityManagerFactoryBean factoryBean){
        assert factoryBean.getObject()!=null;
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
