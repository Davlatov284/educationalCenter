package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.User;
import com.example.educationalcenter.security.JwtUtil;
import com.example.educationalcenter.security.Token;
import com.example.educationalcenter.security.UserMaxsus;
import com.example.educationalcenter.security.UserProvider;
import com.example.educationalcenter.service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/api/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaxsus userMaxsus)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userMaxsus.getUsername(), userMaxsus.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        UserDetails userDetails = userProvider.loadUserByUsername(userMaxsus.getUsername());

        String token = jwtTokenUtil.generateToken(userDetails, userMaxsus.isRememberMe());

        return ResponseEntity.ok(new Token(token));
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
