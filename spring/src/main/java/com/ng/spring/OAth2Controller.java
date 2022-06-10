package com.ng.spring;


import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ng.spring.entities.User;

@RestController
public class OAth2Controller 
{
	@Autowired
	UserService service;
	
	@GetMapping("/home")
	public ModelAndView home(Model model)
	{
		
		 ModelAndView mv = new ModelAndView("home");
		 mv.addObject("user", new User());
		 return mv ;
	}
	
	@GetMapping("/success")
	public ModelAndView success(@RequestParam("code") String code) throws URISyntaxException
	{
		final String baseUrl = "https://www.googleapis.com/oauth2/v4/token";
	    URI uri = new URI(baseUrl);
	    HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
	    RequestTokenParam req = new RequestTokenParam(code,
	    		"954608993195-917bc4lkjvjst7m2vq344c3ul2totfu9.apps.googleusercontent.com", 
	    		"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", 
	    		"http://localhost:8080/success", 
	    		"authorization_code");
	   
		HttpEntity<RequestTokenParam> requestEntity = new HttpEntity<RequestTokenParam>(req, headers);
		
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<GoogleToken> result = restTemplate.postForEntity(uri, requestEntity, GoogleToken.class);
	     
	    System.out.println(result.toString());
	    
	    ResponseEntity<UserInfo> userInfo = restTemplate.getForEntity("https://www.googleapis.com/oauth2/v2/userinfo?access_token="+result.getBody().getAccess_token(), UserInfo.class);
	    
	    System.out.println(userInfo);
		
	    ModelAndView mv = new ModelAndView("view");
	    mv.addObject("user_info", userInfo.getBody());
		return mv ;
	}
}

//954608993195-917bc4lkjvjst7m2vq344c3ul2totfu9.apps.googleusercontent.com
//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