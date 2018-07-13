package com.java.test.Custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@SuppressWarnings("serial")
public class UserDto implements UserDetails {
	private int userNo;
	private String id;
	private String pw;
	private List<String> levels;
	private String mail;
	private String phone;
	private String test = "abc";

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grants = new ArrayList<SimpleGrantedAuthority>();
		for(String role : levels) {
			grants.add(new SimpleGrantedAuthority(role));
		}
		return grants;
		/*
		모든유저에게 권한을 동등한 권한을 부여할시
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER")); //회원가입한 사람은 누구나 ROLE_USER 권한을 갖는다.
        return authorities;
	 */		
	}
	public String gettest() {
		// TODO Auto-generated method stub
		return test;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
