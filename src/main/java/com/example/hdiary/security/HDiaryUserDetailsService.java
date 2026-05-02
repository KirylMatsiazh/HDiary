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
    // loadUserByUsername to follow required signature. Email is used internally for
    // token generation and searches.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        HDiaryUser user = hDiaryUserRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
