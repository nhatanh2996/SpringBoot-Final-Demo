package com.example.finaldemo.config;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.PathResourceResolver;

//</editor-fold>
/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").permitAll()
                .antMatchers("/abc").permitAll()
                .antMatchers("/edit").permitAll()
                .antMatchers("/user").permitAll()
                .antMatchers("/remove").permitAll()
                .antMatchers("/testGet").permitAll()
                .antMatchers("/testPost").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        http.authorizeRequests().anyRequest().authenticated();
        http.cors().and().
                csrf().disable();
    }

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/", "/other-resources/")
//                .setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver());
//
//    }
}
