package com.example.demo.Interface;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import  com.example.demo.Trosak;
import com.example.demo.Trosak.Vrsta;

public interface TrosakRepository extends CrudRepository<Trosak, Long> {
	///Trosak findOne(Long id);
	///Trosak findOne(String id);
	///void deleteByIdNovcanik(Long id);
	///void update(Long id,Novcanik d, Trosak trosak);
	
	///Trosak save(Trosak trosak);
	///void delete(Long id);
	////long count();
	///Iterable<Trosak> findAll();
}
