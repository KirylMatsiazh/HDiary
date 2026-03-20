package com.example.hdiary.security;

import com.example.hdiary.model.HDiaryUser;
import com.example.hdiary.repository.HDiaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class HDiaryUserDetailsService implements UserDetailsService {
    @Autowired
    private HDiaryUserRepository hDiaryUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HDiaryUser user = hDiaryUserRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));;
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
