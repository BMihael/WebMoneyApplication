package com.example.demo;


import java.math.BigDecimal;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.Novcanik;
import com.example.demo.Interface.NovcanikJpaRepository;
import com.example.demo.Interface.NovcanikRepository;
import com.example.demo.Interface.TrosakJpaRepository;
import com.example.demo.Interface.TrosakRepository;

@Controller
@SessionAttributes({"vrste","novcanik","stanjeNaRacunu"})
@RequestMapping("/troskovi")
public class MainController {


	/*
	@Autowired
	private JdbcTrosakRepository jdbcTrosak;
	
	@Autowired
	private JdbcNovcanikRepository jdbcNovcanik;
	*/
	/*
	@Autowired
	private HibernateNovcanikRepository hibernateNovcanikRep;
	*/
	/*
	@Autowired
	private HibernateTrosakRepository hibernateTrosakRep;
	*/
	/*
	@Autowired
	private HibernateUserRepository hibernateUserRep;
	*/
	
	@Autowired
	NovcanikRepository novcanikCrudRepository;
	@Autowired
	TrosakRepository trosakCrudRepository;
	
	@Autowired
	NovcanikJpaRepository novcanikJpaRepository;
	@Autowired
	TrosakJpaRepository trosakJpaRepository;
	
	
	String userMakro;
	
	
	@ModelAttribute("novcanik")
	private Novcanik stvoriNovcanik(HttpSession session) {
		
		System.out.println("kreiram novcanik");
		Novcanik novcanik = new Novcanik();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		userMakro=username;
	
		System.out.println("Ovo je username " + username);
	
		Novcanik novcanik2 = new Novcanik();
		try {
			novcanik2 = novcanikJpaRepository.findByUser(username);
			novcanik2.getId();
		}catch(Exception e){
			novcanik.setUser(username);
			novcanik.setNazivNovcanika("Moj novcanik");
			novcanik.setTip(Novcanik.Tip.BusinessWallet);
			session.setAttribute("stanjeNaRacunu", 0.0);
			
			/////hibernateNovcanikRep.save(novcanik);
			novcanikCrudRepository.save(novcanik);
		}
		
			
		
		Double sumaTroskova= 0.0;
		////Iterable<Trosak> it = jdbcTrosak.findAll();
		///Iterable<Trosak> it = hibernateTrosakRep.findAll();
		Iterable<Trosak> it = trosakCrudRepository.findAll();
		
	
		for(Trosak t : it) {
			if(t.getNovcanik().getId()==novcanik.getId()) {
				novcanik.getTrosakFromNovcanik().add(t);
				sumaTroskova += t.getIznos();
			}
		}
		
		session.setAttribute("stanjeNaRacunu", sumaTroskova);
		
		return novcanik;
	}
	
	
	
	@GetMapping("/resetNovcanik")
	public String resetirajNovcanik(HttpSession session, SessionStatus status) {
		
		////jdbcTrosak.deleteByIdNovcanik((novcanik.getId()));
		////hibernateTrosakRep.deleteByIdNovcanik(novcanik.getId());
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);
		
		trosakJpaRepository.deleteByNovcanikId(novcanik.getId());
		status.setComplete();
		return "redirect:/troskovi/izracun";
	}
	
	
	
	@GetMapping("/izracun")
	public String getIzracun(Model model) {
		model.addAttribute("Trosak",new Trosak());
		model.addAttribute("vrste",Trosak.Vrsta.values());
		
		return "izracun";
	}
	
	
	@GetMapping("/noviEkran")
	public String getNoviEkran(Model model) {
		
		///Novcanik novcanik = jdbcNovcanik.findOne(userMakro);
		///Novcanik novcanik = hibernateNovcanikRep.findOne(userMakro);
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);
		Trosak trosak = new Trosak();
		
		model.addAttribute("NovcanikPrikaz",novcanik);
		model.addAttribute("trosakObjekt",trosak);
		
		Double sumaTroskova = 0.0;
		
		ArrayList<Trosak> podatci = new ArrayList<Trosak>();
		////Iterable<Trosak> it = jdbcTrosak.findAll();
		///Iterable<Trosak> it = hibernateTrosakRep.findAll();
		Iterable<Trosak> it = trosakCrudRepository.findAll();
		
		for(Trosak t : it) {
			if(t.getNovcanik().getId()==novcanik.getId()) {
				podatci.add(t);
				sumaTroskova += t.getIznos();
				
			}
		}
		
		model.addAttribute("SumaTroskova",sumaTroskova);
		model.addAttribute("podatci",podatci);
		
		return "noviEkran";
	}	

	
	@RequestMapping(value = "/troskovi/izracun", method = RequestMethod.GET)
	public String handleDeleteUser(@RequestParam(name="id")Long id,@RequestParam(name="t")Long t) {
		////jdbcTrosak.delete(id);
		if(t==1) {
			
		}else if(t==2) {
			////hibernateTrosakRep.delete(id);
			trosakCrudRepository.deleteById(id);
		}
		////System.out.println("Broj troskova preostalih troskova: " + jdbcTrosak.count());
		////System.out.println("Broj troskova preostalih troskova: " + hibernateTrosakRep.count());
		
	    return "redirect:/troskovi/izracun";
	}
	
	@PostMapping("/update")
    public String greetingSubmit(@ModelAttribute Trosak trosak) {
		
	
        return "redirect:/troskovi/izracun";
    }
	

	


	@PostMapping("/izracun")
	public String showData(Novcanik novcanik, @Validated Trosak trosak, Errors error,Model model, HttpSession session) {
		
		if(error.hasErrors()) {
			System.out.println("Greska, vracam izracun");
			return "izracun";
		}
		
		novcanik = novcanikJpaRepository.findByUser(userMakro);
		
		///trosak.setNovcanik(novcanik.getId());
		trosak.setNovcanik(novcanik);
		/*Tu setaj vrijednosti*/
		////jdbcTrosak.save(trosak);
		////hibernateTrosakRep.save(trosak);

		trosakCrudRepository.save(trosak);
		//// ovo moze a i ne mora novcanikCrudRepository.save(novcanik);
		
		///novcanik.getTrosakFromNovcanik().add(trosak);
		Double lastStanje = 0.0;
		lastStanje = (Double) session.getAttribute("stanjeNaRacunu");
		
		Double iznosTrenutni = 0.0;
		iznosTrenutni = trosak.getIznos();
		
		
		Double konacno =0.0;
		konacno = lastStanje+iznosTrenutni;
		
		model.addAttribute("stanjeNaRacunu",konacno);
		
		return "ShowIzracun";
	}
	
	
	@GetMapping("/search")
	public String getSearch(Model model) {
		
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);

		///Iterable<Trosak> troskovi = trosakCrudRepository.findAll();
		
		model.addAttribute("NovcanikPrikaz",novcanik);
		///model.addAttribute("trosakObjekt",trosak);

		return "search";
	}
	
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/novcanikSearch")
	public String getSearchNovcanik(Model model) {
		
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);

		///Iterable<Trosak> troskovi = trosakCrudRepository.findAll();
		
		model.addAttribute("NovcanikPrikaz",novcanik);
		
		///model.addAttribute("trosakObjekt",trosak);

		return "novcanikSearch";
	}
	
	
	@PostMapping("/novcanikSearch")
	public String getSearchNovcanikData(@RequestParam String search, Model model) {
		
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);

		Iterable<Novcanik> novcanici = novcanikJpaRepository.findByUserContaining(search);
		
		ArrayList<Novcanik> podatci = new ArrayList<Novcanik>();
		
		for(Novcanik t : novcanici) {
				podatci.add(t);
		}
		
		model.addAttribute("nazivNovcanika",novcanik.getNazivNovcanika());
		model.addAttribute("NovcanikPrikaz",novcanik);
		model.addAttribute("podatci",podatci);
		
		return "novcanikSearch";
	}
	
	
	@PostMapping("/search")
	public String getSearchDataShow(@RequestParam String search, Model model) {
		
		Novcanik novcanik = novcanikJpaRepository.findByUser(userMakro);
		
		
		Iterable<Trosak> troskovi = trosakJpaRepository.findByNazivContaining(search);
		
		ArrayList<Trosak> podatci = new ArrayList<Trosak>();
		
		
		for(Trosak t : troskovi) {
			if(t.getNovcanik().getId()==novcanik.getId()) {
				podatci.add(t);
			}
		}
		
		model.addAttribute("NovcanikPrikaz",novcanik);
		model.addAttribute("podatci",podatci);
		return "search";
	}
	

	
	@RequestMapping(value = "/troskovi/search", method = RequestMethod.GET)
	public String handleDeleteTrosak(@RequestParam(name="id")Long id) {
		trosakCrudRepository.deleteById(id);
	    return "redirect:/troskovi/izracun";
	}
	
	
	
}
