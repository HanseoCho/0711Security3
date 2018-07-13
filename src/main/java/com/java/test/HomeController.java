package com.java.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.test.Custom.UserDto;
import com.java.test.Custom.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService us;
	
	@Autowired
	SqlSession ss;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping("/login.html")
	public String login() {
		return "security/login";
	}
	@RequestMapping("/welcome.html")
	public String welcome() {
		return "security/welcome";
	}	
	@RequestMapping("/loginForm.html")
	public String loginForm() {
		return "security/loginForm";
	}		
	@RequestMapping("/testdb")
	public void testdb() {
		//System.out.println(ss.selectList("user.select"));
		HashMap<String, Object> param = new HashMap<String,Object>();
		UserDto result = new UserDto();
		param.put("id", "user");
		param.put("pw", "1234");
		result = ss.selectOne("user.select", param);
		//System.out.println(ss.selectList("user.select", param));
		System.out.println(result.gettest());
		System.out.println(result.getUsername());
	}
}
