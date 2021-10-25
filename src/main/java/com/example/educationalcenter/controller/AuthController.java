package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.User;
import com.example.educationalcenter.security.JwtUser;
import com.example.educationalcenter.security.JwtUtil;
import com.example.educationalcenter.security.MyUserDetailsService;
import com.example.educationalcenter.security.Token;
import com.example.educationalcenter.service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    MyUserDetailsService authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;


    @PostMapping("/api/auth")
    public ResponseEntity<?> login(@RequestBody JwtUser jwtUser) throws Exception {
        authentication(jwtUser.getUsername(), jwtUser.getPassword());

        if (userDetailsService.loadUserByUsername(jwtUser.getUsername()).getPassword().equals(jwtUser.getPassword())) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUser.getUsername());

            final String token = jwtUtil.generateToken(userDetails);
            return new ResponseEntity(new Token(token), HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity(HttpStatus.NON_AUTHORITATIVE_INFORMATION);

    }


    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody User u) throws Exception {
        userService.add(u);
        return new ResponseEntity(HttpStatus.ACCEPTED);
 
    }




    private void  authentication(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }   catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
