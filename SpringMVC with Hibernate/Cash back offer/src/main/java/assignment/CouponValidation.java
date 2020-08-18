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

@Repository
@Transactional
public class CouponValidation {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public int checkCoupon(Coupon p) {
		Session session = sessionFactory.openSession();
		String id=p.getCouponCode();
	    String queryString = "from Coupon c where c.CouponCode= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
		@SuppressWarnings("unchecked")
		List<Coupon> list=query.getResultList();
		 session.close();
		if(list.isEmpty()) {
			return -1;
		}
		else {
			int y=list.get(0).getOfferPercentage();
			return y;
	    	
		}
		
	}

}
