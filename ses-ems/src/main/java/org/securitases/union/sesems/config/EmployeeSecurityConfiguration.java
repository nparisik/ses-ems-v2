package org.securitases.union.sesems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain; 
import static org.springframework.security.config.Customizer.withDefaults;
  
  @Configuration public class EmployeeSecurityConfiguration {
  
  @Bean 
  public SecurityFilterChain filterChain(HttpSecurity http) throws
  Exception { http.authorizeHttpRequests((authz) ->
  authz.anyRequest().authenticated()).httpBasic(withDefaults()); 
  return http.build(); }
 
  //other beans
}
