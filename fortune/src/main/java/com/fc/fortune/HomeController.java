package com.fc.fortune;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value="/fortune", method = RequestMethod.POST)
	public String fortune(Model model, @RequestParam("name") String name) {
	
		model.addAttribute("result", name);
		
		return "fortune";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public String review(Model model, @RequestParam("review") String review) { 
		//���並 ������ �� �������� �����ͺ��̽��� �����ϰ� ������ ȭ���� �����ִ� �޼ҵ�
		System.out.println("���� "+review +"���� �޾ҽ��ϴ�.");
		
		return "review";
	}

	
}
