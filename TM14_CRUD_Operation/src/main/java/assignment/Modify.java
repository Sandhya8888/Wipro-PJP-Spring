package assignment;

import java.math.BigInteger;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import bean.Employee;

@Repository
@Transactional
public class Modify {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public String updateEmployee(String id,Employee e, Map<?, ?> r) {
		Session session = sessionFactory.openSession();
		Employee e1=session.get(Employee.class, id);
		e1.setName((String) r.get("name"));
		e1.setGender((String) r.get("gender"));
		e1.setDesignation((String) r.get("designation"));
		e1.setSalary(Integer.parseInt((String) r.get("salary")));
		e1.setCity((String) r.get("city"));
		e1.setEmail((String) r.get("email"));
		BigInteger mobile=new BigInteger((String)r.get("mobile"));
		e1.setMobile(mobile);
		hibernateTemplate.update(e1);
		session.close();
		return "Updated Successfully";
		
	}
	

}
