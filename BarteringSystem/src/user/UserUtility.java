package user;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import beans.AccountPojo;
import testservletpackage.TestServlet;

public class UserUtility {

	private static Logger log=Logger.getLogger(TestServlet.class.getName());
	private static SessionFactory factory ;
	
	public UserUtility(){
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public boolean validateUser(String email , String password){
		boolean userAuthenticated = false;
		
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(AccountPojo.class);
			Criterion emailcheck = Restrictions.eq("emailId", email);
			Criterion passwordcheck = Restrictions.eq("password", password);
			
			LogicalExpression andExp = Restrictions.and(emailcheck, passwordcheck);
			cr.add( andExp );

			List results = cr.list();
			
			if(results!=null && results.size()>0){
				log.info("User Found ");
				userAuthenticated=true;
			}else{
				log.info("User not found");
			}
			
			
		}catch(HibernateException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return userAuthenticated;
		
	}
}
