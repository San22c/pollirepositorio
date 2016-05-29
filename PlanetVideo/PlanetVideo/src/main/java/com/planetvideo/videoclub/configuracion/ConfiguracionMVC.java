package com.planetvideo.videoclub.configuracion;

import javax.sql.DataSource;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.planetvideo.videoclub.dao.PeliculaDao;
import com.planetvideo.videoclub.dao.PeliculaDaoImpl;
import com.planetvideo.videoclub.dao.UserDaoImpl;
import com.planetvideo.videoclub.dao.UsuarioDao;
 
@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class ConfiguracionMVC extends WebMvcConfigurerAdapter{
 
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/videoclub");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
         
        return dataSource;
    }
     
    @Bean
    public UsuarioDao getUsuarioDAO() {
        return new UserDaoImpl(getDataSource());
    }
    
    @Bean
    public PeliculaDao getPeliculaDAO() {
        return new PeliculaDaoImpl(getDataSource());
    }
    
    
    
}