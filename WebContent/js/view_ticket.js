/**
*
 */
 
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
 
                document.write("<table><tr><th>Case ID</th><th>Created By</th><th>Case Description</th><th>Assigned To</th><th>Current Status</th><th>Last updated on</th><th>Customer Name</th><th>Customer Contact Number</th></tr>");
                var x=xmlDoc.getElementsByTagName("user");
                for (i=0;i<x.length;i++)
                  {
                  document.write("<tr><td>");
                  document.write(x[i].getElementsByTagName("id")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("creator")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("comments")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("assigned_To")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("status")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("timeStamp")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue);
                  document.write("</td><td>");
                  document.write(x[i].getElementsByTagName("contact_number")[0].childNodes[0].nodeValue);
                  document.write("</td></tr>");
                  }
                document.write("</table>");   