package com.example.quizsurveyapp.security;

import com.example.quizsurveyapp.models.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorUserDetails implements UserDetails {
    private String username;
    private String password;
    private final boolean availble;
    private List<GrantedAuthority> authorities;


    public AuthorUserDetails(Author author) {
        username= author.getUsername();
        password= author.getPassword();
        availble= author.isAvailable();
        authorities= Arrays.stream(author.getRoles().split(",")).
                map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return availble;
    }
}
