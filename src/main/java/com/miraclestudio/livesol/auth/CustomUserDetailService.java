package com.miraclestudio.livesol.auth;

import com.miraclestudio.livesol.user.entity.User;
import com.miraclestudio.livesol.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepository userRepository;

    private final UserRoleUtils userRoleUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User findUser = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을수 없습니다."));
        List<String> roleList = findUser.getRoles();
        List<GrantedAuthority> authorities = setAuthenticationToContext(roleList);
        log.info("#### CustomUserDetailService loadUserByUsername()");
        return new UserDetail(findUser);
    }

    private List<GrantedAuthority> setAuthenticationToContext(List<String> roleList) {
        return userRoleUtils.createAuthorities(roleList);
    }

    private final class UserDetail extends User implements UserDetails {

        public UserDetail(User user) {
            setId(user.getId());
            setUsername(user.getUsername());
            setEmail(user.getEmail());
            setPassword(user.getPassword());
            setActive(user.isActive());
            setRoles(user.getRoles());
            setAuthority(user.getAuthority());
            setCreateAt(user.getCreateAt());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
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
            return true;
        }
    }
}
