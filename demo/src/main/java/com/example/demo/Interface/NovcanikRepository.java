package com.example.demo.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Novcanik;

@Repository
@Transactional
public interface NovcanikRepository extends CrudRepository<Novcanik, Long> {
	///Iterable<Novcanik> findAll(String username);
	///Novcanik findOne(Long id);
	///Novcanik findOne(String username);
	///void update(Long id,Novcanik novcanik);
	
	///void delete(Long id);
	///Iterable<Novcanik> findAll();
	///Novcanik save(Novcanik novcanik);
	
}
