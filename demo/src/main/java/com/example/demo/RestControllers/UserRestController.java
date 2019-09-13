package com.example.demo.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HibernateTrosakRepository;
import com.example.demo.HibernateUserRepository;
import com.example.demo.Novcanik;
import com.example.demo.Trosak;
import com.example.demo.User;

/*
@RestController
@RequestMapping(value="/api", produces="application/json")
@CrossOrigin
*/
public class UserRestController {
/*
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	HibernateUserRepository userRepository;
	
	@GetMapping("/user")
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/user/{username}")
	public void delete(@PathVariable String username) {
		userRepository.delete(username);
	}
	
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/user", consumes="application/json") 
	public User save(@RequestBody User user) {
		String password = user.getPassword();
		
		String pass = passwordEncoder.encode(password);
		
		user.setPassword(pass);
		userRepository.save(user);
		return user; 
	}
	
	@PutMapping("/user/{username}") 
	public void update(@PathVariable String username,User userNew,@RequestBody User user) {
		userNew = userRepository.findOne(username);
		userRepository.update(username,userNew,user);
	}
	*/
}
