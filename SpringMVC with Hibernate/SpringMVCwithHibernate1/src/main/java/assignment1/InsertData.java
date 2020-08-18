package assignment1;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import bean.Student;

@Repository
@Transactional 
public class InsertData {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean insertData(Student s2) {
		Session session = sessionFactory.openSession();
		int id=s2.getId();
	    String queryString = "select 1 from Student s where s.id= :id";
	    @SuppressWarnings("rawtypes")
		Query query = session.createQuery(queryString);
	    query.setParameter("id",id);
	    @SuppressWarnings("unchecked")
		List<Student> list=query.getResultList();
	    session.close();
	    if(list.isEmpty()) {
	    	hibernateTemplate.save(s2);
	    	return true;
	    	
	    }
	    else {
	    	return false;
	    }
	}
}
