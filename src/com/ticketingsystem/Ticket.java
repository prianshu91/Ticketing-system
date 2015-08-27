package com.ticketingsystem;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "user")
public class Ticket implements Serializable {

   private static final long serialVersionUID = 1L;
   private String id;
   private String Creator;
   private String Comments;
   private String Assigned_To;
   private String Status;
   private String TimeStamp;
   private String Name;
   private String Contact_number;

   public Ticket(){}

   public Ticket(String id, String Creator, String Comments,String Assigned_To,String Status,String TimeStamp,String Name,String Contact_number){
      this.id = id;
      this.setCreator(Creator);
      this.setComments(Comments);
      this.setAssigned_To(Assigned_To);
      this.setStatus(Status);
      this.setTimeStamp(TimeStamp);
      this.setName(Name);
      this.setContact_number(Contact_number);
   }

   public String getId() {
      return id;
   }
   @XmlElement
   public void setId(String id) {
      this.id = id;
   }
   /**
 * @return the creator
 */
public String getCreator() {
	return Creator;
}
@XmlElement
public void setCreator(String creator) {
	Creator = creator;
}

/**
 * @return the comments
 */
public String getComments() {
	return Comments;
}

@XmlElement
public void setComments(String comments) {
	Comments = comments;
}

/**
 * @return the assignee
 */
public String getAssigned_To() {
	return Assigned_To;
}
@XmlElement
public void setAssigned_To(String assignee) {
	Assigned_To = assignee;
}

/**
 * @return the status
 */
public String getStatus() {
	return Status;
}

@XmlElement
public void setStatus(String status) {
	Status = status;
}

public String getTimeStamp() {
	return TimeStamp;
}

public void setTimeStamp(String timeStamp) {
	TimeStamp = timeStamp;
}

/**
 * @return the name
 */
public String getName() {
	return Name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	Name = name;
}

/**
 * @return the contact_number
 */
public String getContact_number() {
	return Contact_number;
}

/**
 * @param contact_number the contact_number to set
 */
public void setContact_number(String contact_number) {
	Contact_number = contact_number;
}	

//   @Override
//   public boolean equals(Object object){
//      if(object == null){
//         return false;
//      }else if(!(object instanceof Ticket)){
//         return false;
//      }else {
//         Ticket user = (Ticket)object;
//         if(id == user.getId()
//            && name.equals(user.getName())
//            && profession.equals(user.getProfession())
//         ){
//            return true;
//         }			
//      }
//      return false;
//   }	
}