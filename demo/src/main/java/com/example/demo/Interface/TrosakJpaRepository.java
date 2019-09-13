package com.example.demo.Interface;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Trosak;




public interface TrosakJpaRepository extends JpaRepository<Trosak, Long> {
	
	@Modifying
	@Query("delete from Trosak where id_novcanik=:id")
	void deleteByNovcanikId(@Param("id") Long id);
	
	
	List<Trosak> findByNazivContaining(String naziv);
	List<Trosak> findByNazivIgnoreCaseContainingOrderByNazivAsc(String naziv);
	List<Trosak> findByNazivIgnoreCaseContaining(String naziv);
	List<Trosak> findByNazivIgnoreCaseStartingWith(String naziv);
	List<Trosak> findByNazivIgnoreCaseEndingWith(String naziv);
	
	List<Trosak> findByIznosGreaterThan(Double iznos);
	List<Trosak> findByIznosLessThan(Double iznos);
	
	
	@Query("SELECT vrsta, sum(iznos) as SUM, min(iznos) as MIN, max(iznos) as MAX FROM Trosak GROUP BY vrsta")
    List<Object[]> dohvatiPodatkeStatistika();

	
}
