package com.example.demo;

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
public class HibernateUserRepository{
	
	 /////implements UserRepository 
	
/*
	private final EntityManager em;
	
	private Transaction trans;
	
	public HibernateUserRepository(EntityManager em) {
		this.em=em;
	}
	
	@Override
	public Iterable<User> findAll() {
		Session session = (Session)em.getDelegate();
		return session.createQuery("from User",User.class).getResultList();
	}

	@Override
	public User save(User user) {
		Session session = (Session)em.getDelegate();
		trans=session.beginTransaction();
		session.save(user);
		trans.commit();
		return user;
	}

	@Override
	public void delete(String username) {
		Session session = (Session)em.getDelegate();
		trans=session.beginTransaction();
		Query query = session.createQuery("delete from User where username  = :parametar");
		query.setParameter("parametar", username);
		query.executeUpdate();
		trans.commit();
	}

	@Override
	public User findOne(String username) {
		Session session = (Session)em.getDelegate();
		User user = new User();
		Query query = session.createQuery("from User where username =:usernameA");
		query.setParameter("usernameA", username);
		user = (User) query.getSingleResult();
		return user;
	}
	
	@Override
	public void update(String username,User userNew, User user) {
		
	    Session session = (Session)em.getDelegate();
	    trans=session.beginTransaction();
		////Query query = session.createQuery("delete from Novcanik where id  =:parametar");
		////query.setParameter("parametar", id);
		////query.executeUpdate();
	    
	    ////System.out.println("Ovo je unutar update funkcije " + trosak.getNovcanik().getId());
	  
	   
	    userNew.setUsername(user.getUsername());
	    userNew.setPassword(user.getPassword());
	    userNew.setEnabledBit(2);

	    trans.commit();
	    ///session.flush();
	}

	
*/
	

}
