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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import beans.AccountPojo;
import beans.BarterPostPojo;
import beans.TradePojo;
import utils.HibernateConnUtil;

public class TradeUtility {
	
	private static Logger log=Logger.getLogger(TradeUtility.class.getName());
	//private static SessionFactory factory = HibernateConnUtil.getSessionFactory();
	
	public TradeUtility(){
		//factory = new Configuration().configure().buildSessionFactory();
	}
	
	public List<TradePojo> fetchTradeHistory(String email){
		log.info("fetchTradeHistory :: "+email);
		List<TradePojo> tradeList = new ArrayList<TradePojo>();
		int userId = 0;
		
		Transaction tx = null;
		List results = null;
		Session session = HibernateConnUtil.getSessionFactory().openSession();
		try{
			
			log.info("Email obtained in param :: "+email);
			
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(TradePojo.class);
			UserUtility utilObj = new UserUtility();
			userId = utilObj.fetchUserIdFromEmail(email);
			//Criterion usercheck = Restrictions.eq("primaryTraderUserId", userId);
			Criterion usercheck = Restrictions.or(Restrictions.eq("secTraderUserId", userId),Restrictions.eq("primaryTraderUserId", userId));
			Criterion statuscheck = Restrictions.or(Restrictions.eq("requestStatus", "Barter-Finalised"),Restrictions.eq("requestStatus", "Trade-Complete"));
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );
			results = cr.list();
				
			
			
			if(results!=null && results.size()>0){
					for (Iterator iterator = results.iterator(); iterator.hasNext();){
						TradePojo pobj = (TradePojo) iterator.next(); 
						log.info("Trade id ::"+pobj.getTradeId());
						tradeList.add(pobj);
					}
			}else{
					log.info("No Trade result Post Found");
			}
			
			
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return tradeList;
		
		
	}
	
	public List<TradePojo> fetchCurrentRequestSent(String email){
		log.info("fetchTradeHistory :: "+email);
		List<TradePojo> tradeList = new ArrayList<TradePojo>();
		int userId = 0;
		
		Transaction tx = null;
		List results = null;
		Session session = HibernateConnUtil.getSessionFactory().openSession();
		try{
			
			log.info("Email obtained in param :: "+email);
			
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(TradePojo.class);
			UserUtility utilObj = new UserUtility();
			userId = utilObj.fetchUserIdFromEmail(email);
			/*Criterion usercheck = Restrictions.eq("secTraderUserId", userId),Restrictions.eq("primaryTraderUserId", userId));
			Criterion statuscheck = Restrictions.or(Restrictions.eq("requestStatus", "Request-Sent"),Restrictions.eq("requestStatus", "Request-Approved"));
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );
			results = cr.list();
				*/
			
			
			Criterion usercheck = Restrictions.eq("primaryTraderUserId", userId);
			Criterion statuscheck = Restrictions.eq("requestStatus", "Request-Sent");
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );

			results = cr.list();
			
			
			if(results!=null && results.size()>0){
					for (Iterator iterator = results.iterator(); iterator.hasNext();){
						TradePojo pobj = (TradePojo) iterator.next(); 
						log.info("Trade id ::"+pobj.getTradeId());
						tradeList.add(pobj);
					}
			}else{
					log.info("No Trade result Post Found");
			}
			
			
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return tradeList;
		
		
	}
	
	public List<TradePojo> fetchCurrentRequestReceived(String email){
		log.info("fetchTradeHistory :: "+email);
		List<TradePojo> tradeList = new ArrayList<TradePojo>();
		int userId = 0;
		
		Transaction tx = null;
		List results = null;
		Session session = HibernateConnUtil.getSessionFactory().openSession();
		try{
			
			log.info("Email obtained in param :: "+email);
			
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(TradePojo.class);
			UserUtility utilObj = new UserUtility();
			userId = utilObj.fetchUserIdFromEmail(email);
			/*Criterion usercheck = Restrictions.eq("secTraderUserId", userId),Restrictions.eq("primaryTraderUserId", userId));
			Criterion statuscheck = Restrictions.or(Restrictions.eq("requestStatus", "Request-Sent"),Restrictions.eq("requestStatus", "Request-Approved"));
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );
			results = cr.list();
				*/
			
			
			Criterion usercheck = Restrictions.eq("secTraderUserId", userId);
			Criterion statuscheck = Restrictions.eq("requestStatus", "Request-Sent");
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );

			results = cr.list();
			
			
			if(results!=null && results.size()>0){
					for (Iterator iterator = results.iterator(); iterator.hasNext();){
						TradePojo pobj = (TradePojo) iterator.next(); 
						log.info("Trade id ::"+pobj.getTradeId());
						tradeList.add(pobj);
					}
			}else{
					log.info("No Trade result Post Found");
			}
			
			
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return tradeList;
		
		
	}
	
	public List<TradePojo> fetchCurrentTradeApproved(String email){
		log.info("fetchTradeHistory :: "+email);
		List<TradePojo> tradeList = new ArrayList<TradePojo>();
		int userId = 0;
		
		Transaction tx = null;
		List results = null;
		Session session = HibernateConnUtil.getSessionFactory().openSession();
		try{
			
			log.info("Email obtained in param :: "+email);
			
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(TradePojo.class);
			UserUtility utilObj = new UserUtility();
			userId = utilObj.fetchUserIdFromEmail(email);
			/*Criterion usercheck = Restrictions.eq("secTraderUserId", userId),Restrictions.eq("primaryTraderUserId", userId));
			Criterion statuscheck = Restrictions.or(Restrictions.eq("requestStatus", "Request-Sent"),Restrictions.eq("requestStatus", "Request-Approved"));
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );
			results = cr.list();
				*/
			
			
			Criterion usercheck = Restrictions.or(Restrictions.eq("secTraderUserId", userId),Restrictions.eq("primaryTraderUserId", userId));
			Criterion statuscheck = Restrictions.eq("requestStatus", "Request-Approved");
			LogicalExpression andExp = Restrictions.and(usercheck, statuscheck);
			cr.add( andExp );

			results = cr.list();
			
			
			if(results!=null && results.size()>0){
					for (Iterator iterator = results.iterator(); iterator.hasNext();){
						TradePojo pobj = (TradePojo) iterator.next(); 
						log.info("Trade id ::"+pobj.getTradeId());
						tradeList.add(pobj);
					}
			}else{
					log.info("No Trade result Post Found");
			}
			
			
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return tradeList;
		
		
	}
	
	public void approveBarterRequest(String tradeId,String action){
		log.info("approveBarterRequest :: "+tradeId+" Action :: "+action);
		Session session = HibernateConnUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int tradeNo = Integer.parseInt(tradeId);
		try{
			tx=session.beginTransaction();
			Criteria cr = session.createCriteria(TradePojo.class);
			cr.add(Restrictions.eq("tradeId", tradeNo));
			List<TradePojo> record = cr.list();
			
			for (TradePojo obj : record){
				if("approveRequest".equalsIgnoreCase(action))
				obj.setRequestStatus("Request-Approved");
				else if("completeBarter".equalsIgnoreCase(action))
				obj.setRequestStatus("Barter-Finalised");
				session.update(obj);
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}
}
