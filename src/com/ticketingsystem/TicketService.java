package com.ticketingsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/TicketService")
public class TicketService {
	
   TicketDao ticketDao = new TicketDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<html><head><title>System error</title></head><body><h2>There is some error processing your request.Please try after some time</h2></body></html>";;


   @GET
   @Path("/tickets")
   @Produces(MediaType.APPLICATION_XML)
   public List<Ticket> getTickets(){
      return ticketDao.getAllTickets();
   }

   @GET
   @Path("/tickets/search")
   @Produces(MediaType.APPLICATION_XML)
//   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Ticket getTicket(@QueryParam("id") String id){
      return ticketDao.getTicket(id);
   }

   @POST
   @Path("/addticket")
   @Produces("text/html")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String createTicket(@FormParam("id") String id,
      @FormParam("Creator") String Creator,
      @FormParam("Comments") String Comments,
      @FormParam("Assigned_To") String Assigned_To,
      @FormParam("Status") String Status,
      @FormParam("Time") String TimeStamp,
      @FormParam("Name") String Name,
      @FormParam("Contact_number") String Contact_number,
      @Context HttpServletResponse servletResponse) throws IOException{
      Ticket ticket = new Ticket(id, Creator, Comments,Assigned_To,Status,TimeStamp,Name,Contact_number);
      
      String result = ticketDao.createTicket(ticket);
      if(result != null && (!result.equals("Service down."))){
         return "<html><head><title>Success</title></head><body><h2>Case "+result+" has been registered.For more tickets please <a href ='/TicketingSystem/Welcome.html'>click here</a></h2></body></html>";
      }
      if(result != null && result.equals("Service down."))
      {
    	  return "<html><head><title>Success</title></head><body><h2>"+result+"</h2></body></html>";  
      }
      return FAILURE_RESULT;
   }

   @POST
   @Path("/updateticket")
   @Produces("text/html")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateTicket(@FormParam("id") String id,
	  @FormParam("Creator") String Creator,
      @FormParam("Status") String Status,
      @FormParam("Assigned_To") String Assigned_To,
      @FormParam("Comments") String Comments,
      @FormParam("Time") String TimeStamp,
      @FormParam("Name") String Name,
      @FormParam("Contact_number") String Contact_number,
      @Context HttpServletResponse servletResponse) throws IOException{
      Ticket ticket = new Ticket(id, Creator, Comments,Assigned_To,Status,TimeStamp,Name,Contact_number);
      String result = ticketDao.updateTicket(ticket);
      if(result != null && (!result.equals("Service down."))){
          return "<html><head><title>Success</title></head><body><h2>Case "+result+" has been updated.For more tickets please <a href ='/TicketingSystem/Welcome.html'>click here</a></h2></body></html>";
       }
      if(result != null && result.equals("Service down."))
      {
    	  return "<html><head><title>Success</title></head><body><h2>"+result+"</h2></body></html>";  
      }
       return FAILURE_RESULT;
   }


}