package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest_Junit {
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException{
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user1 = new User("spring1","spring1","springno1");
		User user2 = new User("spring2","spring2","springno2");
		User user3 = new User("spring3","spring3","springno3");
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		
		assertThat(dao.getCount(), is(1));
		
		dao.add(user2);
		
		assertThat(dao.getCount(), is(2));
		 
		dao.add(user3);
		
		assertThat(dao.getCount(), is(3));
			
	}
}