package mx.edu.utez.databaseregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class ConexionConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        //dataSourceBuilder.url("jdbc:mysql://localhost:3306/u562742105_sql5414611");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/shop");
        //dataSourceBuilder.url("jdbc:mysql://212.1.211.1:3306/u107415119_51t2022en3");
        //dataSourceBuilder.username("u107415119_51t2022en3");
        //dataSourceBuilder.password("$oP1Dj763@q3");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        //dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }
}