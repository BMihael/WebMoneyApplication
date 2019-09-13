package com.example.demo;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Interface.AuthoritiesRepository;
import com.example.demo.Interface.UserRepository;


@Controller
@RequestMapping(value = "/registration")
public class RegisterController {

	/*
	@Autowired
	private HibernateUserRepository hibernateUserRep;
	*/
	
	@Autowired
	UserRepository userCrudRepository;
	
	@Autowired
	AuthoritiesRepository authoritiesCrudRepository;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@ModelAttribute("User")
	private User stvoriUser() {
		User user = new User();
		return user;
	}
	
	@ModelAttribute("Authorities")
	private Authorities stvoriAuthorities() {
		Authorities authorities = new Authorities();
		return authorities;
	}
	
	@GetMapping("")
	public String ucitajRegistraciju(WebRequest request, Model model) {
	    return "registration";
	}
	
	@PostMapping("")
	public String registracija(@ModelAttribute("User") User user,
								@ModelAttribute("Authorities") Authorities authorities,
								WebRequest request,
								HttpSession session,
								Model model,
								@RequestParam("username") String username,
								@RequestParam("password") String password) {
		
		authorities.setUsername(username);
		authorities.setAuthority("ROLE_ADMIN");
		
		user.setEnabledBit(1);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
	
		userCrudRepository.save(user);
		authoritiesCrudRepository.save(authorities);
		
	    return "redirect:/login";
	}
	
	
	
	
}
