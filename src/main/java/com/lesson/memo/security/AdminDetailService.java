package com.lesson.memo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lesson.memo.repository.AdminRepository;

@Service
public class AdminDetailService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return adminRepository.findByEmail(email)
            .map(admin -> new User(admin.getEmail(), admin.getPassword(), AuthorityUtils.createAuthorityList("ROLE_ADMIN")))
            .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません"));
    }
}