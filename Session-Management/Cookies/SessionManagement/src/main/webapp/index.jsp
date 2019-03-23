<%-- 
    Document   : index
    Created on : Mar 21, 2019, 8:23:07 PM
    Author     : mohamed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
            String userName = null;
            Cookie[] requestCookies = request.getCookies();
            if (requestCookies != null) {
                for (Cookie cookie : requestCookies) {

                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                }
                if (userName == null) {               
                   response.sendRedirect("login.html");

                }
            }

        %> 
       <h3>Hi <%=userName %>, Login successful.</h3>      
       <form action="logoutServlet" method="post" >         
          <input type="submit" value="Logout" />
            
       </form>
       
    </body>
</html>
