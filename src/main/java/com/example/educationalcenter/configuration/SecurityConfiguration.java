package com.example.educationalcenter.configuration;

import com.example.educationalcenter.security.JwtTokenFilter;
import com.example.educationalcenter.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtTokenFilter jwtTokenFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // Our public endpoints
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/student/").authenticated()
                .antMatchers("/api/student/{id}").authenticated()
                .antMatchers("/api/malumot/").authenticated()
                .antMatchers("/api/malumot/{id}").authenticated()
                .antMatchers("/api/kurs/").authenticated()
                .antMatchers("/api/kurs/{id}").authenticated()
                .antMatchers("/api/kursTulov/").authenticated()
                .antMatchers("/api/kursTulov/{id}").authenticated()
                .antMatchers("/api/teacher/").authenticated()
                .antMatchers("/api/teacher/{id}").authenticated()


                // Our private endpoints
                .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
                jwtTokenFilter,
                UsernamePasswordAuthenticationFilter.class
        );


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
