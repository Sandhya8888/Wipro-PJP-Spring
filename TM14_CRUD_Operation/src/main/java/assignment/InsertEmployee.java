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
public class InsertEmployee {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public String insertEmployee(Employee e,User u) {
		Session session = sessionFactory.openSession();
		String id=e.getId();
		String queryString = "select 1 from Employee e where e.id= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
	    @SuppressWarnings("unchecked")
	    List<Employee> list=query.getResultList();
	    String queryString1 = "from Employee e,User u where e.u.username= :username";
	    @SuppressWarnings("rawtypes")
		Query query1 = session.createQuery(queryString1);
	    query1.setParameter("username",u.getUsername());
	    @SuppressWarnings("unchecked")
	    List<Employee> list1=query.getResultList();
	    session.close();
	    if(list.isEmpty() && list1.isEmpty()) {
	    	e.setU(u);
	    	hibernateTemplate.save(e);
	    	return "ok";
	    	
	    }
	    else if(!(list.isEmpty()) && !(list1.isEmpty())) {
	    	return "The employees with the id and username already exists";
	    }
	    else if(!(list.isEmpty())) {
	    	return "The employee with the same id already exists";
	    }
	    
	    else if(!(list1.isEmpty())) {
	    	return "The employee with the same username already exists";
	    }
		return null;
	}
}
