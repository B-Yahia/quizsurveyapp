package com.example.quizsurveyapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableMethodSecurity
public class SecurityConfig {


//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return  http.csrf().disable()
//
//                .authorizeHttpRequests().requestMatchers("/**","/auth/**","/quiz/**").permitAll()
//                .anyRequest().authenticated()
//                .and().build();
//
//    }
//
//
//
//
//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
}
