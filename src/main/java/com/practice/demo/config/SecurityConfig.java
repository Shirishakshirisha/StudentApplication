package com.practice.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // //Buying a lock and bypassing all the securites
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    //     return http.build();

    // }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // http.csrf(customizer -> customizer.disable());
        // http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        // http.formLogin(Customizer.withDefaults());
        // http.httpBasic(Customizer.withDefaults());

        // //Making http stateless
        // http.sessionManagement(session -> sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //

        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrConfiguree<HttpSecurity>();
            
        };

     public void customizer (CsrfConfigurer<HttpSecurity> customizer){
            customizer.disable();
        }
         return http.build();

    }

}
