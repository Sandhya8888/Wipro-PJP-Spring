package assignment;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import bean.Customer;

@Repository
@Transactional 
public class GetBalance {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public int Balance(Customer c) {
		Session session = sessionFactory.openSession();
		String id=c.getCustomerID();
	    String queryString = "from Customer c where c.CustomerID= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Customer> list=query.getResultList();
	    session.close();
		return list.get(0).getBalance();
		
	}
}
