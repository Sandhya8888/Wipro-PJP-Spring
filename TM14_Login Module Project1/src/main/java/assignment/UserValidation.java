package assignment;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import bean.Employee;
import bean.User;


@Repository
@Transactional
public class UserValidation {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Autowired
	SessionFactory sessionFactory;
	
	public String checkUser(User u) {
		Session session = sessionFactory.openSession();
	    String queryString = "from Employee e where e.u= :u";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("u",u);
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		session.close();
	    if(list.isEmpty()) {
	    	String a="Invalid user name or password";
	    	return a;
	    }
	    else {
	    		return "ok";
	    }
		
	}
	

}
