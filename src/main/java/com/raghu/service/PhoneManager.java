package com.raghu.service;

import com.raghu.model.Phone;
import com.raghu.model.User;

public interface PhoneManager {
	public void addPhone(Phone phone);
	public Phone updatePhone(Phone phone);
	public boolean deletePhone(Phone phone);
	public Phone findPhone(int phoneId);
}
