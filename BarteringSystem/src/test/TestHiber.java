package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHiber {

	private static SessionFactory factory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			factory = new Configuration().configure().buildSessionFactory();
			
			TestHiber test  = new TestHiber();
			if(factory!=null){
				System.out.println("Got factory object");
				System.out.println("List Records Now");
				test.listRecords();
				System.out.println("Add Records Now");
				TestingPojo addObj = new TestingPojo();
				addObj.setFirstName("Sachin");
				addObj.setLastName("Tendulkar");
				List<TestingPojo> addList = new ArrayList<TestingPojo>();
				addList.add(addObj);
				int addedId = test.addRecords(addList);
				
				System.out.println("List Records again after add");
				test.listRecords();
				
				System.out.println("Updating Records");
				test.updateRecords(2, "Bhavik", "Shah");
				
				System.out.println("List Records again after update");
				test.listRecords();
				
				System.out.println("Deleting recently added record");
				test.deleteRecords(addedId);
				
				System.out.println("List Records again after delete");
				test.listRecords();
				
			}else{
				System.out.println("No factory object");
				
			}
		}catch(Throwable e){
			System.err.println("Session factory object failed"+e);
			e.printStackTrace();
		}
		
	}

	
	public void listRecords(){
		
		Session session = factory.openSession();
		
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			List records = session.createQuery("FROM TestingPojo").list();
			if(records!=null && records.size()>1){
			for (Iterator iterator = records.iterator(); iterator.hasNext();){
				TestingPojo pobj = (TestingPojo) iterator.next(); 
				System.out.print("Id: " + pobj.getId());
				System.out.print("	First Name: " + pobj.getFirstName()); 
				System.out.print("	Last Name: " + pobj.getLastName());
				System.out.println();
				 
			}
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public int addRecords(List<TestingPojo> addList){
		Session session = factory.openSession();
		Transaction tx =null;
		int id = 0;
		try{
			tx = session.beginTransaction();
			for(TestingPojo testObj : addList){
				id = (Integer)session.save(testObj); 
				System.out.println("Added ID ::"+id);
			}
			 tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return id;
	}
	
	
	public void updateRecords(int id , String firstName, String lastName){
		Session session = factory.openSession();
		Transaction tx=null;
		try{
			tx = session.beginTransaction();
			TestingPojo obj = (TestingPojo) session.get(TestingPojo.class, id);
			obj.setFirstName(firstName);
			obj.setLastName(lastName);
			session.update(obj);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	public void deleteRecords(int id){
		Session session = factory.openSession();
		Transaction tx=null;
		try{
			tx = session.beginTransaction();
			TestingPojo obj = (TestingPojo) session.get(TestingPojo.class, id);
			session.delete(obj);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}


