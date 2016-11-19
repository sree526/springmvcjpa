package com.raghu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.model.Phone;
import com.raghu.model.User;

@Repository
@Transactional
public class PhoneDAOImpl implements PhoneDAO{

	@PersistenceContext
    private EntityManager manager;
	
	public void addPhone(Phone phone) {
		
		manager.persist(phone);
		//System.out.println(manager.find(Phone.class,9));
	}

	public Phone updatePhone(Phone phone) {
		int Pid=phone.getPhoneId();
		manager.merge(phone);
		Phone phone2=manager.find(Phone.class,Pid);
		return phone2;
		
	}
	@Transactional
	public boolean deletePhone(Phone phone) {
		
		Phone phone2 = manager.merge(phone);
		manager.remove(phone2);
		
		return true;
		
	}

	public Phone findPhone(int phoneId) {
		
		Phone phone;
		try{
			phone=manager.find(Phone.class,phoneId);
		}catch(IllegalArgumentException e){
			return null;
		}
		return phone;
	}

}
