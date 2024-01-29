package hr.intellexi.demo.tickemanageradmin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String DATABASE_URL;

    @Value("${spring.datasource.username}")
    private String DATABASE_ADMIN_NAME;

    @Value("${spring.datasource.password}")
    private String DATA_BASE_ADMIN_PASS;

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(DATABASE_URL);
        dataSourceBuilder.username(DATABASE_ADMIN_NAME);
        dataSourceBuilder.password(DATA_BASE_ADMIN_PASS);
        return dataSourceBuilder.build();
    }

    @Bean
    public NamedParameterJdbcTemplate getnamedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
