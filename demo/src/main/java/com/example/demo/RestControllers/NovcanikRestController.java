package com.example.demo.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.demo.HibernateNovcanikRepository;
import com.example.demo.HibernateTrosakRepository;
import com.example.demo.Novcanik;

/*
@RestController
@RequestMapping(value="/api", produces="application/json")
@CrossOrigin
*/
public class NovcanikRestController {
/*
	@Autowired
	HibernateTrosakRepository trosakRespository;
	
	@Autowired
	HibernateNovcanikRepository novcanikRepository;
	
	@GetMapping("/novcanik")
	public Iterable<Novcanik> findAll(){
		return novcanikRepository.findAll();
	}
	
	@GetMapping("/novcanik/{id}")
	public ResponseEntity<Novcanik> findOne(@PathVariable String id) {
		Novcanik novcanik= novcanikRepository.findOne(id);
		if(novcanik != null) {
			return new ResponseEntity<>(novcanik, HttpStatus.OK);
		} else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/novcanik/{id}")
	public void delete(@PathVariable String id) {
		Long i = Long.valueOf(id).longValue();
		trosakRespository.deleteByIdNovcanik(i);
		novcanikRepository.delete(i);
	}
	
	@PutMapping("/novcanik/{id}") 
	public void update(@PathVariable String id,@RequestBody Novcanik novcanik) {
		Long i = Long.valueOf(id).longValue();
		novcanikRepository.update(i, novcanik);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value="/novcanik", consumes="application/json") 
	public Novcanik save(@RequestBody Novcanik novcanik) {
		novcanikRepository.save(novcanik);
		return novcanik; 
	}
	
	
	*/
	
}
