package com.livraria.service;

import com.livraria.domain.user.User;
import com.livraria.domain.user.UserDetailsImpl;
import com.livraria.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuario nao encontrando"));
        return new UserDetailsImpl(user);
    }
}
