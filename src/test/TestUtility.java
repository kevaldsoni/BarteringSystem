package test;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import testservletpackage.TestServlet;

public class TestUtility {
	
	private static Logger log=Logger.getLogger(TestServlet.class.getName());
	
	public String storeUserDetails(TestBean user){
		
		if(log.isInfoEnabled())
			log.info("Entering TestUtility : storeUserDetails method");
		
		
		Session session=null;
		Transaction tx = null;
		String userId = null;
		
		 SessionFactory factory;
		try{
			
			factory = new Configuration().configure().buildSessionFactory();
			
			session=factory.openSession();
			tx = session.beginTransaction();
			
			TestingPojo userDetails=new TestingPojo();
			
			userDetails.setFirstName(user.getName());
			userDetails.setLastName(user.getEmail().substring(0, 9));
			int id=(Integer)session.save(userDetails);
			userId = id+"";
			log.debug("Entering TestUtility : storeUserDetails method : User Id generated : "+userId);
			
			tx.commit();
		
			
		}catch (HibernateException e) {
	         if (tx!=null) 
	        	 	tx.rollback();
	         
	   
	         userId=null;
	         
	         log.error("TestUtility : storeUserDetails method : Exception :"+e);
	         e.printStackTrace(); 
		}catch(Exception e){
		
			e.printStackTrace();
		
		}finally {
		
			if (session!=null) session.close(); 
		}
		
		if(log.isInfoEnabled())
			log.info("Exiting TestUtility : storeUserDetails method");
		
		return userId;
	}

}
