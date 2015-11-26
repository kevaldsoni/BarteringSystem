package user;

import java.util.Iterator;
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
import beans.UserPojo;
import test.TestingPojo;
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
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return userAuthenticated;
		
	}
	
	public String fetchUsername(String email){
		String name=null;
		
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("emailId", email));
			List results = cr.list();
			
			if(results!=null && results.size()>0){
				log.info("User Found ");
				for (Iterator iterator = results.iterator(); iterator.hasNext();){
					UserPojo pobj = (UserPojo) iterator.next(); 
					name= pobj.getFirstName();
				}
			}else{
				log.info("User not found");
			}
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return name;
		
	}
	
	public int fetchUserIdFromEmail(String email){
		int userId=0;
		
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("emailId", email));
			List results = cr.list();
			
			if(results!=null && results.size()>0){
				log.info("User Found ");
				for (Iterator iterator = results.iterator(); iterator.hasNext();){
					UserPojo pobj = (UserPojo) iterator.next(); 
					userId= pobj.getUserId();
				}
			}else{
				log.info("User not found");
			}
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return userId;
		
	}
	
	
	public int addNewUser(UserPojo userObj){
		int  userId = 0;
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			userId = (Integer)session.save(userObj);			
			if(userId > 0){
				log.info("New User Created !! with id :: "+userId);	
			}else{
				log.info("User Creation Failed");
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		

		return userId;
	}
	
	public boolean addNewUserDetailsToAccount(AccountPojo account){
		boolean result = false;
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			
			int id = (Integer)session.save(account);			
			if(id > 0){
				log.info("Account Updated for new user !! with id :: "+id);
				result=true;
			}else{
				log.info("Account update Failed");
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return result;
	}
}
