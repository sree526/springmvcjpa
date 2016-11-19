package com.raghu.dao;

import com.raghu.model.Phone;

public interface PhoneDAO {

	public void addPhone(Phone phone);

	public Phone updatePhone(Phone phone);

	public boolean deletePhone(Phone phone);

	public Phone findPhone(int phoneId);
}
