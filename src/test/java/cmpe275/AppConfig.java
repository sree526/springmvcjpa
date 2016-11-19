package cmpe275;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.raghu.dao.UserDAOImpl;
import com.raghu.service.UserManagerImpl;

@Configuration
public class AppConfig {
	@Bean
	    public UserManagerImpl getSampleService() {
	        return new UserManagerImpl();
	    }
	@Bean
		public UserDAOImpl hello(){
		return new UserDAOImpl();
	}
	 @Bean
	    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
	        return entityManagerFactory.createEntityManager();
	    }

}
