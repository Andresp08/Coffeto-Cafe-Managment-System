package com.andresoft.cafe.configuration.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.andresoft.cafe.model.User;
import com.andresoft.cafe.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {
    
    @Autowired
    private IUserRepository userRepository;

    private User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername {} ", username);
        userDetail = userRepository.findByEmail(username);
        if(!Objects.isNull(userDetail)) {
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public User getUserDetail() {
        User user = userDetail;
        user.setPassword(null);
        return user;
        //return userDetail;
    }
}
