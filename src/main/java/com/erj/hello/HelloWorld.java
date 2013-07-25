package com.erj.hello;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erj.persistence.HibernateUtil;

public class HelloWorld {
	
	static Long msgId = 0L;
	
	public static void main(String [] args){
		
		firstUnitOfWork();
		
		secondUnitOfWork();
		
		thirdUnitOfWork();
		
		HibernateUtil.shutdown();
	}

	private static void firstUnitOfWork() {
		Session firstSession = HibernateUtil.getSessionFactory().openSession();
		Transaction firstTransaction = firstSession.beginTransaction();
		
		Message message = new Message("JPA:  Hello, World!");
		msgId = (Long)firstSession.save(message);
		
		firstTransaction.commit();
		firstSession.close();
	}

	@SuppressWarnings("rawtypes")
	private static void secondUnitOfWork() {
		Session secondSession = HibernateUtil.getSessionFactory().openSession();
		Transaction secondTransaction = secondSession.beginTransaction();
		
		List messages = secondSession.createQuery("from Message m order by m.text asc").list();
		
		System.out.println(messages.size() + " message(s) were found:");
		
		for(Iterator iter = messages.iterator(); iter.hasNext();){
			Message loadedMsg = (Message) iter.next();
			System.out.println(loadedMsg.getText());
		}
		
		secondTransaction.commit();
		secondSession.close();
	}

	private static void thirdUnitOfWork() {
		Message message;
		Session thirdSession = HibernateUtil.getSessionFactory().openSession();
		Transaction thirdTransaction = thirdSession.beginTransaction();
		
		message = (Message) thirdSession.get(Message.class, msgId);
		message.setText("JPA:  Greetings, Earthling.");
		message.setNextMessage(new Message("JPA:  Take me to your leader."));
		
		thirdTransaction.commit();
		thirdSession.close();
	}
}
