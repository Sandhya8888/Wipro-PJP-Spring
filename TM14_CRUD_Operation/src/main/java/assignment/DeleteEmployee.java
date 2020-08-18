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
public class DeleteEmployee {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Employee> getEmployee(Employee e,User u) {
		Session session = sessionFactory.openSession();
		String id=e.getId();
		String queryString = "from Employee e where e.id= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
	    @SuppressWarnings("unchecked")
	    List<Employee> list=query.getResultList();
	    return list;
	}

}
