package com.example.demo.Interface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Novcanik;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NovcanikJpaRepositoryTest {

	@Mock
	NovcanikJpaRepository novcanikJpaRepository;
	
	@Test
	public void testFindByUser() {
		
		LocalDateTime time = LocalDateTime.now();
		
		Novcanik novcanik = new Novcanik();
		
		novcanik.setCreateDate(time);
		novcanik.setNazivNovcanika("Belko");
		novcanik.setTip(Novcanik.Tip.BusinessWallet);
		novcanik.setUser("admin");
		
		novcanikJpaRepository.findByUser(anyString());
		
		assertNotNull(novcanik);

	}

	@Test
	public void testFindByUserContaining() {
		List<Novcanik> nov = novcanikJpaRepository.findByUserContaining(anyString());
		assertNotNull(nov);
		for(int i=0;i<nov.size();i++) {
			assertTrue((nov.get(i).getId())!=null);
		}
	}

}
