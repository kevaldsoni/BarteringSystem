package user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import beans.AccountPojo;
import beans.BarterPostPojo;
import beans.UserPojo;
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
	
	
	public List<BarterPostPojo> fetchBarteringPosts(String category){
		
		List<BarterPostPojo> barterList = new ArrayList<BarterPostPojo>();
		
		Transaction tx = null;
		Session session = factory.openSession();
		try{
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(BarterPostPojo.class);
			if("All".equalsIgnoreCase(category)){
				List results = cr.list();
				if(results!=null && results.size()>0){
					for (Iterator iterator = results.iterator(); iterator.hasNext();){
						BarterPostPojo pobj = (BarterPostPojo) iterator.next(); 
						log.info("Barter Post ID :: "+pobj.getReqId());
						barterList.add(pobj);
					}
				}else{
					log.info("No Barter Post Found");
				}
			}else{
				
			}
			/*Finding Total Pages for Pagination*/
			int maxResultsPerPage = 6;
			int totalRecords = barterList.size();
			int totalPages=(totalRecords%maxResultsPerPage==0?totalRecords/maxResultsPerPage:(totalRecords/maxResultsPerPage)+1);
			log.info("Total Records :: "+totalRecords+" No of pages required ::"+totalPages);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return barterList;
	}
	

}
