package com.callor.book.service.auth;

import com.callor.book.model.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(!username.equals("GOGOYS")){
            throw new UsernameNotFoundException(username + "전보를 찾을 수 없음")
        }

        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        UserVO userVO = UserVO.builder()
                .username(username)
                .password("Gogoys1020!")
                .enabled(true)
                .authorities(authList)
                .build();

        return userVO;
    }
}
