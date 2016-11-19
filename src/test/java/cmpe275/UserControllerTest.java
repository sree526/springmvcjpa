package cmpe275;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.raghu.controller.UserController;
import com.raghu.dao.PhoneDAO;
import com.raghu.dao.UserDAO;
import com.raghu.dao.UserDAOImpl;
import com.raghu.model.Address;
import com.raghu.model.Phone;
import com.raghu.model.User;
import com.raghu.service.UserManager;
import com.raghu.service.UserManagerImpl;

import junit.framework.Assert;
import junit.framework.TestCase;
@ContextConfiguration(locations = "classpath:spring-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest{

	@Autowired
    private UserDAO employeeDAO;
     
    @Autowired
    private PhoneDAO departmentDAO;
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddDepartment()
    {
        Phone departments = departmentDAO.findPhone(1);
        System.out.println(departments.getNumber());
        Assert.assertEquals(departments.getNumber(), "1");
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testgetUser(){    	
    		User user1=employeeDAO.findUser(1);
    		System.out.println(user1.getFirstname());
    		Assert.assertEquals(user1.getFirstname(), "1");
    }
    @Test
    @Transactional
    @Rollback(true)
    public void testaddUser(){
    		User user=new User();
    		Address address=new Address();
    		address.setCity("san jose");
    		address.setState("CA");
    		address.setStreet("Market");
    		address.setZip("34522");
    		user.setAddress(address);
    		user.setFirstname("sreekar");
    		user.setLastname("m");
    		Phone phone=new Phone();
    		phone.setAddress(address);
    		phone.setDescription("pirmary");
    		phone.setNumber("325928");
    		List<Phone> phones=new ArrayList<Phone>();
    		user.setPhones(phones);
    		boolean user1=employeeDAO.addUser(user);
    		Assert.assertEquals(user1, true);
    }
    
    
    
}
