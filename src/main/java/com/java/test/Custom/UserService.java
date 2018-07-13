package com.java.test.Custom;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService {
	@Autowired
	SqlSession ss;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = getUserById(username);
		System.out.println(user);
		return null;
	}
	public UserDto getUserById(String username) {
		HashMap<String, Object> param = new HashMap<String,Object>();
		UserDto result = new UserDto();
		param.put("id", username);
		param.put("pw", "1234");
		result = (UserDto) ss.selectList("user.select", param);
		return result;
	}
}
