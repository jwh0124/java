package com.circle.demo.customer.service;

import com.circle.demo.customer.domain.User;
import com.circle.demo.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if(user == null) {
            throw new UsernameNotFoundException("The requested user is not found.");
        }
        return new LoginUserDetails(user);
    }
}
