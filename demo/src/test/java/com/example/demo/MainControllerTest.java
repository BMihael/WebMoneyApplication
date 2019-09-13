package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.Interface.NovcanikJpaRepository;
import com.example.demo.Interface.NovcanikRepository;
import com.example.demo.Interface.TrosakJpaRepository;
import com.example.demo.Interface.TrosakRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	@InjectMocks
	MainController mainController;
	
	@Mock
	TrosakRepository trosakRepository;
	
	@Mock
	TrosakJpaRepository trosakJpaRepository;
	
	@Mock
	NovcanikJpaRepository novcanikJpaRepository;

	@Autowired 
	private MockMvc mockMvc;

	@Autowired
	NovcanikRepository novcanikRepository;
	
	EntityManager em;
	
	

	@Test
	public void testGetIzracun() throws Exception {
		
		this.mockMvc 
			.perform(get("/troskovi/izracun")
			.with(user("admin")
			.password("adminpass") 
			.roles("USER", "ADMIN")))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("novcanik"));
	}
	
	
	@Test
	public void testStvoriNovcanik() throws Exception {
		this.mockMvc 
		.perform(get("/troskovi/izracun")
		.with(user("admin")
		.password("adminpass") 
		.roles("USER", "ADMIN")))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("novcanik"));
	}
	
	
	@Test
	public void testResetNovcanik() throws Exception {
		
		LocalDateTime time = LocalDateTime.now();
		
		
		Novcanik novcanik = new Novcanik();
		novcanik.setId(1L);
		novcanik.setCreateDate(time);
		novcanik.setNazivNovcanika("Belko");
		novcanik.setTip(Novcanik.Tip.BusinessWallet);
		novcanik.setUser("admin");
		
		
		when(novcanikJpaRepository.findByUser("user1")).thenReturn(novcanik);
	
		
		this.mockMvc
		.perform(get("/troskovi/resetNovcanik")
		.with(user("admin")
		.password("adminpass") 
		.roles("USER", "ADMIN")))
		.andExpect(status().isOk());
		
	}
	
	@Test
	public void testHandleDeleteTrosak() throws Exception {
		this.mockMvc 
		.perform(get("/troskovi/search")
		.with(user("admin")
		.password("adminpass") 
		.roles("USER", "ADMIN")).param("id", "1"))
		.andExpect(status().isOk());
	}

	@Test
	public void test() throws Exception {
		this.mockMvc 
		.perform(get("/login")
		.with(user("admin")
		.password("adminpass") 
		.roles("USER", "ADMIN")))
		.andExpect(status().isOk())
		.andExpect(view().name("login"));
	}

	@Test
	public void testPostgetSearchNovcanikData() throws Exception {
		this.mockMvc.perform(post("/troskovi/novcanikSearch")
				.with(user("admin")
				.password("adminpass") 
				.roles("USER", "ADMIN"))
				.param("search", "auto"))
				.andExpect(model().attributeExists("nazivNovcanika"))
				.andExpect(model().attributeExists("NovcanikPrikaz"))
				.andExpect(model().attributeExists("podatci"))
				.andExpect(status().isOk())
				.andExpect(view().name("novcanikSearch"));
	}
	
	
	@Test
	public void testCreateTrosak() {
		LocalDateTime time = LocalDateTime.now();
		Trosak trosak = new Trosak();
		Novcanik novcanik = new Novcanik();
		
		trosak.setCreateDate(time);
		trosak.setId(1L);
		trosak.setIznos(200.0);
		trosak.setNaziv("Trosak1");
		trosak.setVrsta(Trosak.Vrsta.Hrana);
		trosak.setNovcanik(novcanik);
		
		when(trosakJpaRepository.save(trosak)).thenReturn(trosak);
		////assertEquals(trosak,trosakRepository.save(trosak));
	}

	
	@Test
	public void testGetIdTrosak() {
		Trosak trosak = new Trosak();
		trosak.setId((long)1);
		
		assertEquals(1,trosak.getId().intValue());
	}
	
	@Test
	public void testFindByNazivContaining() {
		String naziv = "Hambi";
		//Iterable<Trosak> troskovi = trosakJpaRepository.findByNazivContaining(search);
		when(trosakJpaRepository.findByNazivContaining(naziv))
		.thenReturn(Stream.of(new Trosak()).collect(Collectors.toList()));
		///assertEquals(1,trosakJpaRepository.findByNazivContaining(naziv));
	}
	

	@Test
	public void testGetNoviEkran() throws Exception {
		this.mockMvc.perform(get("/troskovi/noviEkran")
		.with(user("admin")
		.password("adminpass") 
		.roles("USER", "ADMIN")))
		.andExpect(status().isOk())
		.andExpect(view().name("noviEkran"));
	}
	
	@Test
	public void testPostGetSearchDataShow() throws Exception {
		this.mockMvc.perform(post("/troskovi/search")
				.with(user("admin")
				.password("adminpass") 
				.roles("USER", "ADMIN"))
				.param("search", "auto"))
				.andExpect(model().attributeExists("NovcanikPrikaz"))
				.andExpect(model().attributeExists("podatci"))
				.andExpect(status().isOk())
				.andExpect(view().name("search"));
	}
	

	@Test
	public void testPostShowData() throws Exception {
		Optional<Novcanik> novcanik = novcanikRepository.findById(1L);
	
		this.mockMvc
		.perform(post("/troskovi/izracun")
				.with(user("admin")
				.password("adminpass") 
				.roles("USER", "ADMIN"))
		.param("naziv", "trosak1")
		.param("vrsta", "Hrana")
        .param("iznos", "100.0")
        .sessionAttr("novcanik", novcanik))
        .andExpect(model().attributeExists("stanjeNaRacunu"))
		.andExpect(view().name("ShowIzracun"));
	}
	
	
	
	
}
