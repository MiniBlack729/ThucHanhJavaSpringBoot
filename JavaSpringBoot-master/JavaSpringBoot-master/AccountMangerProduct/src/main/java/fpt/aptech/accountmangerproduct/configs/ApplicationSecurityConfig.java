package fpt.aptech.accountmangerproduct.configs;

import fpt.aptech.accountmangerproduct.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //phan role access cho page
                .antMatchers("/showAll", "/showAllProduct").hasAnyAuthority("Admin", "Manager", "User")
                .antMatchers("/createAdmin", "/createProduct").hasAnyAuthority("Admin", "Manager")
                //for admin, manager
                .antMatchers("/updateAccount/**", "/updateProduct/**", "/deleteProduct/**").hasAnyAuthority("Admin", "Manager")
                .antMatchers("/deleteAccount/**").hasAuthority("Manager")
                .anyRequest().permitAll() // all rest of other pages not require login when access
//                .anyRequest().authenticated() // all rest of other pages require login when access
                .and()
                .formLogin()
                .loginPage("/login") //use a page login dc chi dinh hơn dùng page mặc định
                .defaultSuccessUrl("/") //redirect to showAll page after login success
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/page403")
        ;
    }
}
