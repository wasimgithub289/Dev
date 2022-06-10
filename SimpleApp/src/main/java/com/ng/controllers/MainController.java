package com.ng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController 
{
	@RequestMapping(value="/login", method=RequestMethod.GET)    
    public String login() {    
            
        return "loginPage";    
    }
	
	
	 @PostMapping("/login_success_handler")
	  public String loginSuccessHandler() {
	    //perform audit action
	    return "index";
	  }

	  @PostMapping("/login_failure_handler")
	  public String loginFailureHandler() {
	    //perform audit action
	    return "login";
	  }
}
