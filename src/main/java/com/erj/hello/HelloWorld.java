package com.erj.hello;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloWorld {
	
	static Long msgId = 0L;
	
	public static void main(String [] args){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message("Hello World, JPA to the max");
		em.persist(message);
		em.persist(new Message("this is a test"));
		
		tx.commit();
		em.close();
		
		
		
		EntityManager secondEm = emf.createEntityManager();
		EntityTransaction secondTx = secondEm.getTransaction();
		secondTx.begin();
		
		List<?> messages = secondEm.createQuery("select m from Message m order by m.text asc").getResultList();
		
		System.out.println(messages.size() + " message(s) found");
		
		for (Object m : messages){
			Message loadedMsg = (Message) m;
			System.out.println(loadedMsg.getText());
		}
		secondTx.commit();
		secondEm.close();
		
		emf.close();
	}
}
