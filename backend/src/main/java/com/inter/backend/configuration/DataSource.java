package com.inter.backend.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Slf4j
public class DataSource {
        @Value("${db.mgmt.driverclass}")
        String dbDriverClass;
        @Value("${db.mgmt.url}")
        String dbUrl;
        @Value("${db.mgmt.username}")
        String dbUsername;
        @Value("${db.mgmt.password}")
        String dbPassword;

        @Bean
        public javax.sql.DataSource connection() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(dbDriverClass);
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            log.info("datasource connection established");
            log.info("Database URL : " + dbUrl);

            return dataSource;
        }
}
