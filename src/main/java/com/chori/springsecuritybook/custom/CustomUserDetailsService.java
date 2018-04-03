package com.chori.springsecuritybook.custom;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class CustomUserDetailsService implements UserDetailsService {
    private Map<String, UserInfo> userMap = new HashMap<>();
    private Map<String, List<UserPermission>> permMap = new HashMap<>();

    public CustomUserDetailsService() {
        userMap.put("system", new UserInfo("system", "시스템", "sys"));
        permMap.put("system", Arrays.asList(new UserPermission(1L, "SYSTEM_USER")));
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = findUserInfo(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        }

        List<UserPermission> perms = loadPermission(userInfo.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserPermission perm : perms) {
            authorities.add(new SimpleGrantedAuthority(perm.getName()));
        }
        return new User(username, userInfo.getPassword(), authorities);
    }

    private UserInfo findUserInfo(String username) {
        return userMap.get(username);
    }

    private List<UserPermission> loadPermission(String username) {
        return permMap.get(username);
    }
}
