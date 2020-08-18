package assignment;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import bean.Employee;

@Repository
@Transactional
public class DeleteEmployee2 {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public String deleteEmployee(String id,Employee e) {
		Session session = sessionFactory.openSession();
		Employee e1=session.get(Employee.class, id);
		hibernateTemplate.delete(e1);
		session.close();
		return "Deleted";
		
	}
	

}
