package assignment;

import java.util.List;
import java.util.ListIterator;

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
public class LoginValidation {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public String check(Customer c) {
		Session session = sessionFactory.openSession();
		String id=c.getCustomerID();
	    String queryString = "from Customer c where c.CustomerID= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Customer> list=query.getResultList();
		session.close();
	    if(list.isEmpty()) {
	    	String a="No customer exists with this id ";
	    	return a;
	    }
	    else {
	    	ListIterator<Customer> i = list.listIterator();
	    	int f=1;
	    	while(i.hasNext()) {
	    		if(c.getPassword().equals(i.next().getPassword())) {
	    			f=0;
	    			break;
	    		}
	    	}
	    	if(f==0) {
	    		return "ok";
	    	}
	    	else {
	    		String a="Invalid password";
		    	return a;
	    	}
	    }
	}
	public int Balance(Customer c) {
		if(check(c).equals("ok")) {
			return c.getBalance();
		}
		return 0;
		
	}

	
}
