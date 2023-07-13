package kz.finalbitlab.spawn.config;

import kz.finalbitlab.spawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.exceptionHandling().accessDeniedPage("/403-page");


        AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService()).passwordEncoder(passwordEncoder());


        httpSecurity.formLogin()
                .loginPage("/sign-in-page")  // "/sign-in-page" Controller page
                .loginProcessingUrl("/to-enter") // <form action = "/to-enter" method = "post">
                .usernameParameter("user_email") // <input type = "email" name = "user_email">
                .passwordParameter("user_password") // <input type = "password" name = "user_password">
                .defaultSuccessUrl("/profile") // response.sendRedirect("/profile")
                .failureUrl("/sign-in-page?autherror");

        httpSecurity.logout()
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/sign-in-page");

        httpSecurity.csrf().disable();


        return httpSecurity.build();
    }
}
