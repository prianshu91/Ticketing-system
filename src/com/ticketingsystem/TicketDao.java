package com.ticketingsystem;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class TicketDao {
	MongoDBJDBC mdb = new MongoDBJDBC();
	DBCollection coll = mdb.createConnection();
	DBCursor cursor = null;
	Ticket tp = null;
	WriteResult status_chk = null;
	static Logger log = Logger.getLogger(TicketDao.class.getName());
	
public List<Ticket> getAllTickets(){
	
	List<Ticket> ticketList = new ArrayList<Ticket>();
		      Map<String,String> mp = new HashMap<String,String>();
		      try{
      
      cursor = coll.find();
      while (cursor.hasNext()) {  
         mp = cursor.next().toMap(); 
         tp = new Ticket(mp.get("id"),mp.get("Creator"),mp.get("Comments"),mp.get("Assigned_To"),mp.get("Status"),mp.get("Time"),mp.get("Name"),mp.get("Contact_number"));
         ticketList.add(tp);
         
      }
	}
      catch(Exception ex)
      {
    	  log.info(ex.toString());
      }
      return ticketList;
   }
   
   public Ticket getTicket(String id){

	   BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", id);
	      cursor = coll.find(whereQuery);
	      Map<String,String> mp = new HashMap<String,String>();
	      if(cursor.count() == 0)
		   {
			   tp=new Ticket("","","No records found for the given id.Please enter the correct id.","","","","","");
			   return tp;
		   }
	      mp = cursor.next().toMap();
	      tp = new Ticket(mp.get("id"),mp.get("Creator"),mp.get("Comments"),mp.get("Assigned_To"),mp.get("Status"),mp.get("Time"),mp.get("Name"),mp.get("Contact_number"));
	   
	   
	   return tp;
   }

   public String createTicket(Ticket cmp){
	   try{
	   BasicDBObject doc = new BasicDBObject("id",cmp.getId()).
	            append("Creator", cmp.getCreator()).
	            append("Comments", cmp.getComments()).
	            append("Assigned_To", cmp.getAssigned_To()).
	            append("Status", cmp.getStatus()).
	            append("Time", cmp.getTimeStamp()).
	            append("Name", cmp.getName()).
	            append("Contact_number", cmp.getContact_number());
	   status_chk = coll.insert(doc);
	   } catch(Exception ex)
	      {
	    	  log.info(ex.toString());
	    	  return "Service down.";
	      }
	   if(status_chk.getLastError() != null){    
//		     logger.error("ERROR"); 
		     return cmp.getId();
	   }
	   else
	   {
		   return null;
	   }
	   
      
   }

   public String updateTicket(Ticket cmp){
	   BasicDBObject whereQuery = new BasicDBObject("id",cmp.getId());
try
{
			BasicDBObject doc = new BasicDBObject("id",cmp.getId()).
		            append("Creator", cmp.getCreator()).
		            append("Comments", cmp.getComments()).
		            append("Assigned_To", cmp.getAssigned_To()).
		            append("Status", cmp.getStatus()).
		            append("Time", cmp.getTimeStamp()).
		            append("Name", cmp.getName()).
		            append("Contact_number", cmp.getContact_number());
		            status_chk = coll.update(whereQuery, doc);
}
			catch(Exception ex)
		      {
		    	  log.info(ex.toString());
		    	  return "Service down.";
		      }
			if(status_chk.getLastError() != null){    
//			     logger.error("ERROR"); 
			     return cmp.getId();
		   }
		   else
		   {
			   return null;
		   }
   }
}