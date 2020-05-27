package com.bobocode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * This class is provides root Java config for Spring application.
 * <p>
 * todo: 0. PLEASE NOTE, THAT SOME REQUIRED STEPS ARE OMITTED IN THE TODO LIST AND YOU HAVE TO DO IT ON YOUR OWN
 * <p>
 * todo: 1. Configure {@link PlatformTransactionManager} bean with name "transactionManager"
 * todo: 2. Enable transaction management
 */
@Configuration
@ComponentScan("com.bobocode")
@EnableTransactionManagement
public class RootConfig {


    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
       return new JpaTransactionManager(entityManagerFactory);
    }
}

