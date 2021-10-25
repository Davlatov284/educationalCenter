package com.example.educationalcenter.security;

import com.example.educationalcenter.entity.User;
import com.example.educationalcenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = this.userRepository.findByUsername(s);

        if (u != null)
        return new JwtUser(u);

        throw new UsernameNotFoundException("Topilmadi");
    }

    public void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
    }
}
