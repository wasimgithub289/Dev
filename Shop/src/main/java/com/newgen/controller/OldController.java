package com.newgen.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newgen.model.User;


@Controller
public class OldController {

	@PersistenceContext
	EntityManager em;
 
	@GetMapping("/home")
    public ModelAndView home() {
		ModelAndView modelView = new ModelAndView("index");
		User user = new User();
		modelView.addObject(user);
        return modelView;
    }
	
	@PostMapping("/show")
	@Transactional
    public ModelAndView show(@ModelAttribute("user") @Valid User user, BindingResult result) 
	{
		User u = new User();
		u.setName("Wasim");
		u.setAddress("Hello");
		em.persist(u);
		
		
		if(result.hasErrors())
		{
			ModelAndView modelView = new ModelAndView("Home");
			modelView.addObject(user);
	        return modelView;
		}
		else
		{
			ModelAndView modelView = new ModelAndView("showResult");
			modelView.addObject(user);
	        return modelView;
		}
		
    }
}  