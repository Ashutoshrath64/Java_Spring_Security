package com.Ashutosh.Spring_Security_Demo.config;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private UserDetailsService user;

   @Bean
    public AuthenticationProvider authorisation(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(user);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;


    }





    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        //disable Csrf token
//        security.csrf(Customizer -> Customizer.disable());
//        //Authorise Http Request
//        security.authorizeHttpRequests(request->request.anyRequest().authenticated());
//        //Enable form
//        security.httpBasic(Customizer.withDefaults());
//        security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        security.csrf(Customizer->Customizer.disable()).authorizeHttpRequests(
                request->request.anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).sessionManagement(Session->
                Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));





        return security.build();

    }

    @Bean
    public UserDetailsService userDetailServices(){
        UserDetails user1= User.withDefaultPasswordEncoder().username("Ashutosh Rath").password(

                "12345"
        ).build();

        UserDetails user2 = User.withDefaultPasswordEncoder().username("badmin").password("System123#").build();

        return  new InMemoryUserDetailsManager(user1,user2);
    }


}
