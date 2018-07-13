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
		if(user == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		return user;
	}
	

	public UserDto getUserById(String username) {
		HashMap<String, Object> param = new HashMap<String,Object>();
		UserDto result = new UserDto();
		param.put("id", "user");
		param.put("pw", "1234");
		result = ss.selectOne("user.select", param);
		return result;
	}
}
