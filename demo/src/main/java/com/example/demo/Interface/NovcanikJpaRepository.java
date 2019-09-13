package com.example.demo.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Novcanik;
import com.example.demo.Trosak;

public interface NovcanikJpaRepository extends JpaRepository<Novcanik, Long> {
	Novcanik findByUser(String user);
	
	List<Novcanik> findByUserContaining(String user);
}
