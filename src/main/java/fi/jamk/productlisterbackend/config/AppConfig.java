/*
 */
package fi.jamk.productlisterbackend.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Antti Minkkinen
 */
@Configuration
@ComponentScan("fi.jamk.productlisterbackend")
@EnableWebMvc
public class AppConfig {

	@Bean(name="dataSource")
    public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("dbuser");
        ds.setPassword("ProductDBUser1");
        ds.setUrl("jdbc:mysql://localhost:3306/productdb");
        return ds;
    }
}
