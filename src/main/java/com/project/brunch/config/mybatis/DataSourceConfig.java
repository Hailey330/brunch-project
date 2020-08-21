package com.project.brunch.config.mybatis;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

// 실제 디비에 요청, 응답을 대기시킴

@Configuration
public class DataSourceConfig {

   @ConfigurationProperties(prefix = "spring.datasource")
   public DataSource dataSource() {
      return DataSourceBuilder.create().build();
   }
}