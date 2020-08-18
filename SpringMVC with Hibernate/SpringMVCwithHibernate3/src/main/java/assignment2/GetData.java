package assignment2;

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
public class GetData {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Student> getList(Student s2){
		Session session2 = sessionFactory.openSession();
	    String queryString = "from Student s";
	    @SuppressWarnings("rawtypes")
		Query query = session2.createQuery(queryString);
	    @SuppressWarnings("unchecked")
		List<Student> list=query.getResultList();
	    session2.close();
		return list;
		
	}

}
