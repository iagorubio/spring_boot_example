package com.iagorubio.ioweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

/*
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/public/**" ,"/index.html", "/").permitAll()
            .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
            //.exceptionHandling().accessDeniedPage("/accessDenied.html");
    }

/*
    //InMemoryUserDetailsManager in case there is no database access
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        Collection<UserDetails> users = new ArrayList<UserDetails>();
        UserDetails admUser = User.withDefaultPasswordEncoder()
                .username("adm")
                .password("pwd123")
                .roles("ADMIN")
                .build();
        users.add(admUser);

         UserDetails publicUser = User.withDefaultPasswordEncoder()
                .username("user")
                .password("pwd123")
                .roles("USER")
                .build();
        users.add(publicUser);

        return new InMemoryUserDetailsManager(publicUser);
    }
*/
    @Bean
    public UserDetailsManager userDetailsService() {
        return new JdbcUserDetailsManager() {{
            setDataSource(dataSource);
            setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
            setAuthoritiesByUsernameQuery("select username, authority from authorities where username = ?");
            setCreateUserSql(DEF_CREATE_USER_SQL);
        }};
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
        //return new  BCryptPasswordEncoder(10);
    }
}
