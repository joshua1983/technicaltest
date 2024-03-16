package com.inclusion.technicaltest.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      return http
         .csrf().disable()
         .authorizeRequests()
         .anyRequest().authenticated()
         .and()
         .httpBasic()
         .and()
         .sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .build();

   }

   @Bean
   UserDetailsService userDetailsService() {

      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      manager.createUser(
         org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
            .username("user").password(passwordEncoder().encode("password")).roles("USER").build());
      return manager;
   }

   @Bean
   PasswordEncoder passwordEncoder() {
      return new PasswordEncoder() {
         @Override
         public String encode(CharSequence charSequence) {
            return new BCryptPasswordEncoder().encode(charSequence.toString());
         }

         @Override
         public boolean matches(CharSequence charSequence, String s) {
            return true;
         }
      };
   }

   @Bean
   AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder encoder) throws Exception {
      return http.getSharedObject(AuthenticationManagerBuilder.class)
         .userDetailsService(userDetailsService()).passwordEncoder(encoder).and().build();
   }
}
