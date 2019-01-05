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
	private static Properties prop;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { //첫 화면을 보여주는 메소드
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}
	
	@RequestMapping(value="/submit", method = RequestMethod.POST)
	public String fortune(Model model, @RequestParam("name") String name) {
		//python script 실행한 결과를 통해 fortune cookie의 결과를 보여주는 메소드
		String pythonPath  = prop.getProperty("pythonPath");
		
		ProcessBuilder pb = new ProcessBuilder("python","model.py", name);
		pb.directory(new File(pythonPath));
	
		try{
			Process p = pb.start();
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String result = in.readLine();
			model.addAttribute("result", result);
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return "fortune";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public String review(Model model, @RequestParam("review") String review) { 
		//리뷰를 남겼을 때 리뷰결과를 데이터베이스에 저장하고 마지막 화면을 보여주는 메소드
		
		System.out.println("리뷰 "+review +"점을 받았습니다.");
		
		return "review";
	}
	
	@PostConstruct //Controller 생성과 함께 init 메소드로 설정. config를 읽어올 수 있도록!
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
