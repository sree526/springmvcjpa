package com.raghu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.model.Phone;
import com.raghu.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
    private EntityManager manager;
	public boolean addUser(User user) {
		
		try{
		List<Phone> phones=new ArrayList<Phone>();
		for(int i=0;i<user.getPhones().size();i++){
			Query q=manager.createQuery("select p from Phone p where p.number=:id",Phone.class);
			q.setParameter("id",user.getPhones().get(i).getNumber());
			Phone phone=(Phone)q.getSingleResult();
			phones.add(phone);
		}
		/*q.setParameter("id",user.getPhones().get(1).getNumber());
		Phone phone2=(Phone)q.getSingleResult();
		phones.add(phone2);*/
		user.setPhones(phones);	
		manager.persist(user);
		return true;
		}catch(Exception E){
			return false;
		}
	}
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		try{
			user=manager.find(User.class,userId);
		}catch(IllegalArgumentException e){
			return null;
		}
		//System.out.println(user);
		return user;
	}
	public User updateUser(User user) {
		int Uid=user.getUserId();
		
		List<Phone> phones=new ArrayList<Phone>();
		for(int i=0;i<user.getPhones().size();i++){
			Query q=manager.createQuery("select p from Phone p where p.number=:id",Phone.class);
			q.setParameter("id",user.getPhones().get(i).getNumber());
			Phone phone=(Phone)q.getSingleResult();
			phones.add(phone);
		}
	
		user.setPhones(phones);
		manager.merge(user);
		User user2=manager.find(User.class,Uid);
		return user2;
	}
	
	@Transactional
	public boolean deleteUser(User user) {
		 
		User user2 = manager.merge(user);
		manager.remove(user2);
		
		return true;
	}

}
