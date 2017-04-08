/*package com.room.expense.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfig {
@Bean //This tells to spring container that return type of method (DataSource) needs to set up as bean.
@ConfigurationProperties(prefix="spring.datasource")// tells datasource builder to use the connection from properties start with given name
@Primary
public DataSource dataSource()
{
	return DataSourceBuilder.create().build();
}
}
*/