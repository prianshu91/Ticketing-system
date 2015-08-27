package com.ticketingsystem;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.util.HashMap;
import java.util.Map;

public class MongoDBJDBC{
   public DBCollection createConnection(){
	   DBCollection coll = null;
	   Map<String,String> mp = new HashMap<String,String>();
      try{   
		 // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
         DB db = mongoClient.getDB( "ticket_db" );
		 System.out.println("Connect to database successfully");
		char[] myPassword = new char[] {'s', 'e', 'c', 'r', 'e', 't'};
		boolean auth = db.authenticate("root", myPassword);
		 System.out.println("Authentication: "+auth);
		 coll = db.getCollection("details");
         }
      catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }
      return coll;
   }
}
