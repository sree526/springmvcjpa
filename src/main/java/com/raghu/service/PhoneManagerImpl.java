package com.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.dao.PhoneDAO;
import com.raghu.model.Phone;
import com.raghu.model.User;

@Service
public class PhoneManagerImpl implements PhoneManager{

	@Autowired
    PhoneDAO dao;
	public void addPhone(Phone phone) {
		
		dao.addPhone(phone);
	}
	public Phone updatePhone(Phone phone) {
		Phone phone2=dao.updatePhone(phone);
		return phone2;
	}
	public boolean deletePhone(Phone phone) {
		
		return dao.deletePhone(phone);
	}
	public Phone findPhone(int phoneId) {
		
		return dao.findPhone(phoneId);
	}

}
