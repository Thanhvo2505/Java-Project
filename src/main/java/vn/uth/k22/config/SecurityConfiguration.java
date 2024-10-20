package vn.uth.k22.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


 // Bean Spring quản lí
@Configuration
public class SecurityConfiguration  {
    @Bean
    // return a instance BCryptPasswordEncoder
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
