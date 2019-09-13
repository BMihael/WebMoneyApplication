package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/*
@Primary
@Repository
@Transactional
*/
public class HibernateNovcanikRepository  {
	
	//// implements NovcanikRepository
	
	/*
	private final EntityManager em;
	
	private Transaction trans;
	
	public HibernateNovcanikRepository(EntityManager em) {
		this.em=em;
	}
	
	@Override
	public Iterable<Novcanik> findAll() {
		Session session = (Session)em.getDelegate();
		return session.createQuery("from Novcanik",Novcanik.class).getResultList();
	}

	@Override
	public Iterable<Novcanik> findAll(String username) {
		Session session = (Session)em.getDelegate();
		List<Novcanik> novcanik = new ArrayList<Novcanik>();
		Query query = session.createQuery("from Novcanik where user =:userA");
		query.setParameter("userA", username);
		novcanik = query.getResultList();
		
		return novcanik;
	}

	@Override
	public Novcanik findOne(Long id) {
		Session session = (Session)em.getDelegate();
		Novcanik novcanik = new Novcanik();
		Query query = session.createQuery("from Novcanik where id =:idA");
		query.setParameter("idA", id);
		novcanik = (Novcanik)query.getSingleResult();
		return novcanik;
	}

	@Override
	public Novcanik findOne(String username) {
		Session session = (Session)em.getDelegate();
		Novcanik novcanik = new Novcanik();
		Query query = session.createQuery("from Novcanik where user =:userA");
		query.setParameter("userA", username);
		novcanik = (Novcanik)query.getSingleResult();
		return novcanik;
	}

	@Override
	public Novcanik save(Novcanik novcanik) {
		novcanik.setCreateDate(LocalDateTime.now());
		Session session = (Session)em.getDelegate();
		Long id = (Long)session.save(novcanik);
		novcanik.setId(id);
		return novcanik;
	}
	
	@Override
	public void delete(Long id) {
	    Session session = (Session)em.getDelegate();
	    trans=session.beginTransaction();
		Query query = session.createQuery("delete from Novcanik where id  =:parametar");
		query.setParameter("parametar", id);
		query.executeUpdate();
		trans.commit();
	}
	
	
	@Override
	public void update(Long id, Novcanik novcanik) {
		Novcanik novcanik2 = new Novcanik();
	    Session session = (Session)em.getDelegate();
	    trans=session.beginTransaction();
		////Query query = session.createQuery("delete from Novcanik where id  =:parametar");
		////query.setParameter("parametar", id);
		////query.executeUpdate();
	    
	    novcanik2 = session.byId(Novcanik.class).load(id);
	    novcanik2.setNazivNovcanika(novcanik.getNazivNovcanika());
	    novcanik2.setTip(novcanik.getTip());
	    novcanik2.setCreateDate(novcanik.getCreateDate());
	    novcanik2.setUser(novcanik.getUser());
	    novcanik2.setId(novcanik.getId());
	    trans.commit();
	    ///session.flush();
	}
	
	
	
	
	*/
	


}
