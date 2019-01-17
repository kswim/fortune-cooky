package com.fc.fortune.admin;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fc.fortune.Fortune;
import com.fc.fortune.HomeController;
import com.fc.fortune.service.FortuneService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FortuneService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static Properties prop;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) { 
		logger.info("Welcome administrator."); 
		
		return "/admin/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session,
			@RequestParam("id")String id, @RequestParam("password") String pw) { 
		
		if(prop.getProperty("admin.id").equals(id) 
				&& prop.getProperty("admin.pw").equals(pw)) { 
			session.setAttribute("adminId", id);
			session.setAttribute("adminPw", pw);
			logger.info("Login administrator");
		}
		else {
			return "redirect:/admin/";
		}
		
		return "/admin/loginOk";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "/admin/home";
	}
	
	@RequestMapping(value="/check", method = RequestMethod.GET)
	public String check(Model model) {
		List<Fortune> fortunes = service.fortuneSearchAll();
		model.addAttribute("fortunes", fortunes);
		
		return "/admin/check";
	}
	
	@PostConstruct
	public static void loadConfig(){
		prop = new Properties();
		
		String config = "config.properties";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(config); 
		
		try {
			prop.load(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
