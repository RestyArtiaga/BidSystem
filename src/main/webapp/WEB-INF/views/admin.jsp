<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <title>Bidding System - Admin</title>

    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/override.css" rel="stylesheet">
	
  </head>
  <body>
    <div class="container">
        
        <div class="form-container">
          <h1>ADMIN PAGE</h1>
          <!-- Add Item Form-->

            
            <h1>Form</h1>
	    <form modelAttribute="user" enctype="application/x-www-form-urlencoded" action="<c:url value='/login' />" object="${user}" method="post">
	    	<p>username: <input type="text" field="*{username}" /></p>
	        <p>password: <input type="text" field="*{password}" /></p>
	        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	    </form>                      
           
          </form>
        </div>
    </div> 
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
  </body>
</html>