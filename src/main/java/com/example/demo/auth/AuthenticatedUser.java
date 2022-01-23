//package com.example.demo.auth;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class AuthenticatedUser extends User implements UserDetails {
//
//    protected AuthenticatedUser(User user) {
//        super(user.getUsername(), user.getPassword(), user.isAccountNonExpired(), user.isAccountNonLocked(), user.isCredentialsNonExpired(),user.isEnabled());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return AuthorityUtils.createAuthorityList("ROLE_USER","ADMIN");
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.isEnabled();
//    }
//}
