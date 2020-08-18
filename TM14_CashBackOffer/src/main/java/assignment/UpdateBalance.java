package assignment;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import bean.Coupon;
import bean.Customer;

@Repository
@Transactional 
public class UpdateBalance {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	public int uBalance(String id,Coupon p) {
		Session session = sessionFactory.openSession();
		String queryString1 = "from Customer t where t.CustomerID= :id";
		Query query1 = session.createQuery(queryString1);
	    query1.setParameter("id",id);
	    @SuppressWarnings("unchecked")
		List<Customer> list1=query1.getResultList();
		int balance=list1.get(0).getBalance();
		String o=p.getCouponCode();
		String queryString = "from Coupon c where c.CouponCode= :o";
		Query query = session.createQuery(queryString);
	    query.setParameter("o",o);
	    @SuppressWarnings("unchecked")
		List<Coupon> list=query.getResultList();
	    int cash=list.get(0).getOfferPercentage();
	    int UpBal=balance+((balance*cash)/100);
	    Customer c1=session.get(Customer.class, id);
	    c1.setBalance(UpBal);
	    hibernateTemplate.update(c1);
		session.close();
		return UpBal;
		
	}

}
