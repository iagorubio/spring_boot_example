package com.iagorubio.ioweb.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource()
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/io_web");
        dataSourceBuilder.username("iowebuser");
        dataSourceBuilder.password("iowebpwd");
        return dataSourceBuilder.build();
    }
}
