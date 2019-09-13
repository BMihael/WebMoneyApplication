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
import com.example.demo.JdbcNovcanikRepository;
import com.example.demo.JdbcTrosakRepository;
import com.example.demo.Novcanik;
import com.example.demo.Trosak;
import com.example.demo.Interface.NovcanikRepository;
import com.example.demo.Interface.TrosakRepository;

/*
@RestController
@RequestMapping(value="/api", produces="application/json")
@CrossOrigin
////@RequestMapping(path="/api/trosak", produces="application/json")
 */
public class TrosakRestController {

	/*
	@Autowired
	HibernateTrosakRepository trosakRepository;
	
	@Autowired
	HibernateNovcanikRepository novcanikRepository;
	
	*/
	
	/*
	public TrosakRestController(JdbcTrosakRepository trosakRespository, NovcanikRepository novcanikRepository) {
		this.trosakRespository = trosakRespository;
		this.novcanikRepository = novcanikRepository;
	}
	*/
	
	/*
	@GetMapping("/trosak")
	public Iterable<Trosak> findAll(){
		return trosakRepository.findAll();
	}
	
	@GetMapping("/trosak/{id}")
	public ResponseEntity<Trosak> findOne(@PathVariable String id) {
		////pretvaranje string u long za id u bazi
		Long i = Long.valueOf(id).longValue();
		Trosak trosak= trosakRepository.findOne(i);
		if(trosak != null) {
		return new ResponseEntity<>(trosak, HttpStatus.OK);
		} else {
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/trosak/{id}")
	public void delete(@PathVariable String id) {
		Long i = Long.valueOf(id).longValue();
		trosakRepository.delete(i);
	}
	
	
	@PutMapping("/trosak/{id}") 
	public void update(@PathVariable String id,@RequestBody Trosak trosak) {
		Long i = Long.valueOf(id).longValue();
		Long d = trosakRepository.idNovcanikByIdTrosak(i);
		Novcanik novcanik = novcanikRepository.findOne(d);
		trosakRepository.update(i,novcanik,trosak);
	}
	
	
	@ResponseStatus(HttpStatus.CREATED) 
	@PostMapping(value="/trosak", consumes="application/json") 
	public Trosak save(@RequestBody Trosak trosak) {
		Long d = trosakRepository.idNovcanikByIdTrosak(trosak.getId());
		Novcanik novcanik = novcanikRepository.findOne(d);
		trosak.setNovcanik(novcanik);
		trosakRepository.save(trosak);
		return trosak;
	}
	
	*/
}
