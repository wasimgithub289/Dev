package com.ng.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ng.entities.User;
import com.ng.services.UserService;

@RestController
@RequestMapping("/maker")
public class MakerController
{
	@Autowired
	UserService service;
	
	@GetMapping("/addUser")
	public ModelAndView addUser()
	{
		ModelAndView mv= new ModelAndView("addUser");
		User user = new User();
		mv.addObject("user", user);
		mv.addObject("userList", service.getAllUser());
		mv.addObject("userCount", service.getUserCount());
		return mv;
	}
	
	@GetMapping("/getAllUsers")
	public ModelAndView getAllUsers()
	{
		ModelAndView mv= new ModelAndView("makerInbox");
		mv.addObject("userList", service.getAllUser());
		return mv;
		
	}
	
	@PostMapping("/saveUser")
	public ModelAndView saveUser(@Valid User user,Errors errors, ModelAndView mv)
	{
		if(errors.hasErrors())  
        {  
   		 	mv.addObject("message", errors.getFieldError());
   		 	mv.setViewName("addUser");
   		 	return mv; 
        }    
        else  
        {  

            int id = service.saveUser(user);
            String message = "Record with id : '"+id+"' is saved successfully !";
            mv.addObject("user", new User());
            mv.addObject("message", message);
            mv.addObject("userList", service.getAllUser());
            mv.setViewName("addUser");
            
            return mv; 
        }  
	}
}
