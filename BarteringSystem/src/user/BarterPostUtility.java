package user;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.AccountPojo;
import beans.BarterPostPojo;
import testservletpackage.TestServlet;

public class BarterPostUtility {
	
	private static Logger log=Logger.getLogger(TestServlet.class.getName());
	private static SessionFactory factory ;
	
	public BarterPostUtility(){
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	
	public int addNewBarterPost(BarterPostPojo barterPostObj){
		int reqId = 0;
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			
			reqId = (Integer)session.save(barterPostObj);			
			if(reqId > 0){
				log.info("New Barter Post Uploaded with reqId :: "+reqId);
				
			}else{
				log.info("Barter Post Upload Failed");
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return reqId;
	}
	
	

}
