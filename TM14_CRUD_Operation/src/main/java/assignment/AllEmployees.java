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

@Repository
@Transactional
public class AllEmployees {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		String queryString = "from Employee e";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    @SuppressWarnings("unchecked")
	    List<Employee> list=query.getResultList();
	    return list;
	}

}
