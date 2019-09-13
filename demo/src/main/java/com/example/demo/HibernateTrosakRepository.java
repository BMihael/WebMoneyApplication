package com.example.demo;

import java.time.LocalDateTime;


import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Trosak.Vrsta;
/*
@Primary
@Repository
@Transactional
*/
public class HibernateTrosakRepository  {
	
	////implements TrosakRepository
/*
	private final EntityManager em;

	private Transaction trans;
	
	public HibernateTrosakRepository(EntityManager em) {
		this.em=em;
	}

	
	@Override
	public Iterable<Trosak> findAll() {
		Session session = (Session)em.getDelegate();
		
		return session.createQuery("from Trosak",Trosak.class).getResultList();
	}

	@Override
	public Trosak findOne(Long id) {
		Session session = (Session)em.getDelegate();
		Trosak trosak = new Trosak();
		Query query = session.createQuery("from Trosak where id =:idA");
		query.setParameter("idA", id);
		trosak = (Trosak) query.getSingleResult();
			
		return trosak;
	}

	@Override
	public Trosak save(Trosak trosak) {
		trosak.setCreateDate(LocalDateTime.now());
		Session session = (Session)em.getDelegate();
		Long id = (Long)session.save(trosak);
		trosak.setId(id);
		
		return trosak;
	}

	private long saveTrosakDetails(Trosak trosak) {
		Session session = (Session)em.getDelegate();
		
	
		Long id = (Long)session.save(trosak);
		return id;
	}


	@Override
	public void delete(Long id) {
	    Session session = (Session)em.getDelegate();
	    trans=session.beginTransaction();
		Query query = session.createQuery("delete from Trosak where id  = :parametar");
		query.setParameter("parametar", id);
		query.executeUpdate();
		trans.commit();
	}

	
	@Override
	public void deleteByIdNovcanik(Long id) {
		Session session = (Session)em.getDelegate();
		trans=session.beginTransaction();
		Query query = session.createQuery("delete Trosak where id_novcanik  = :id");
		query.setParameter("id", id);
		query.executeUpdate();	
		trans.commit();
	}

	@Override
	public int count() {
		Session session = (Session)em.getDelegate();
		Query query = session.createQuery("Select count(s) from Trosak s");
		
		return query.getFirstResult();
	}


	@Override
	public Trosak findOne(String id) {
		Session session = (Session)em.getDelegate();
		Trosak trosak = new Trosak();
		Query query = session.createQuery("from Trosak where id =:idA");
		query.setParameter("idA", id);
		trosak = (Trosak) query.getSingleResult();
			
		return trosak;
	}

	
	@Override
	public void update(Long id, Novcanik novcanik,Trosak trosak) {
		
		Trosak trosak2 = new Trosak();
	    Session session = (Session)em.getDelegate();
	    trans=session.beginTransaction();
		////Query query = session.createQuery("delete from Novcanik where id  =:parametar");
		////query.setParameter("parametar", id);
		////query.executeUpdate();
	    
	    ////System.out.println("Ovo je unutar update funkcije " + trosak.getNovcanik().getId());
	  
	    trosak2 = session.byId(Trosak.class).load(id);
	    trosak2.setId(trosak.getId());
	    trosak2.setCreateDate(trosak.getCreateDate());
	    trosak2.setIznos(trosak.getIznos());
	    trosak2.setNaziv(trosak.getNaziv());
	    trosak2.setNovcanik(novcanik);
	    trosak2.setVrsta(trosak.getVrsta());
	    trans.commit();
	    ///session.flush();
	}
	
	
	public Long idNovcanikByIdTrosak(Long id) {
		Session session = (Session)em.getDelegate();
		Trosak trosak = new Trosak();
		Query query = session.createQuery("from Trosak where id =:idA");
		query.setParameter("idA", id);
		trosak = (Trosak) query.getSingleResult();
		System.out.println("ID JE: " + trosak.getNovcanik().getId());
		
		return trosak.getNovcanik().getId();
	}
*/

	
}
