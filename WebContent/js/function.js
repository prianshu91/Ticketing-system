/**
*
 */
 
function getCurrentDate()
{
                var today = new Date();
                document.getElementById('Time').value=today;            
}
 
function createRequest() {
                getCurrentDate();
                var param1var = getQueryVariable("id");
                var url = "http://localhost:8079/TicketingSystem/rest/TicketService/tickets/search?id="+param1var+"&log_ticket=Search";
                if (window.XMLHttpRequest)
                  {// code for IE7+, Firefox, Chrome, Opera, Safari
                  xmlhttp=new XMLHttpRequest();
                  }
                else
                  {// code for IE6, IE5
                  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                  }
                xmlhttp.open("GET",url,false);
                xmlhttp.send();
                xmlDoc=xmlhttp.responseXML;
                var x=xmlDoc.getElementsByTagName("user");
                var Comments=x[0].getElementsByTagName("comments")[0].childNodes[0].nodeValue;
                //alert(Comments+"sdvdfv")
                if(Comments === "No records found for the given id.Please enter the correct id.")
                                {
                                alert(Comments);
                                window.location.href = '/TicketingSystem/search_ticket.html';
                                }
                //alert(x[0].getElementsByTagName("timeStamp")[0].childNodes[0].nodeValue);
                else
                                {
                var Creator=x[0].getElementsByTagName("creator")[0].childNodes[0].nodeValue;
                var Assigned_To=x[0].getElementsByTagName("assigned_To")[0].childNodes[0].nodeValue;
              
                var Status=x[0].getElementsByTagName("status")[0].childNodes[0].nodeValue;
                var Time=x[0].getElementsByTagName("timeStamp")[0].childNodes[0].nodeValue;
                var Name=x[0].getElementsByTagName("name")[0].childNodes[0].nodeValue;
                var Contact_number=x[0].getElementsByTagName("contact_number")[0].childNodes[0].nodeValue;
              
                document.getElementById('id').value=param1var;
                document.getElementById('Creator').value=Creator;
                document.getElementById('Assigned_To').value=Assigned_To;
                document.getElementById('Comments').value=Comments;
                document.getElementById('Status').value=Status;
                document.getElementById('Previous_Time').value=Time;
                document.getElementById('Name').value=Name;
                document.getElementById('Contact_number').value=Contact_number;
              
                if(Status === "Closed")
                                {
                                document.getElementById('Creator').setAttribute("readonly","true");
                                document.getElementById('Assigned_To').setAttribute("readonly","true");
                                document.getElementById('Comments').setAttribute("readonly","true");
                                document.getElementById('Status').setAttribute("disabled","true");
                                document.getElementById('Name').setAttribute("readonly","true");
                                document.getElementById('Contact_number').setAttribute("readonly","true");
                                document.getElementById('update_ticket').setAttribute("disabled","true");
                                document.getElementById('Reset').setAttribute("disabled","true");
                                }
                                }
}
 
function reset_fn()
{
    document.getElementById('Creator').value="";
    document.getElementById('Assigned_To').value="";
    document.getElementById('Comments').value="";
    document.getElementById('Status').value="New";
    document.getElementById('Name').value="";
    document.getElementById('Contact_number').value="";
}
 
function getTicketId(){
                getCurrentDate();
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.open("GET","http://localhost:8079/TicketingSystem/rest/TicketService/tickets",false);
                xmlhttp.send();
                xmlDoc=xmlhttp.responseXML;
 
                var x=xmlDoc.getElementsByTagName("user");
                document.getElementById('id').value=1000+x.length+1;
                }
 
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}