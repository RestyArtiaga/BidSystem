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

          <form action="<c:url value='/admin/addItem' />" enctype="application/x-www-form-urlencoded" method="POST">
            <h2 class="form-signin-heading">Add Item</h2>
            <label for="inputEmail" class="sr-only">Item Name</label>
            <input type="text" id="itemName" class="form-control" placeholder="Item Name" required="" autofocus="">
            <label for="inputPassword" class="sr-only">User ID</label>
            <input type="text" id="userID" class="form-control" placeholder="User ID" required="">
            <label for="inputPassword" class="sr-only">Item Description</label>
            <input type="text" id="itemDescription" class="form-control" placeholder="Item Description" required="">
            <label for="inputPassword" class="sr-only">Bid Duration</label>
            <input type="text" id="duration" class="form-control" placeholder="Bid Duration(hours)" required="">
            <label for="inputPassword" class="sr-only">Starting Bid</label>
            <input type="text" id="currentPrice" class="form-control" placeholder="Starting Bid" required="">
           
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add Item</button>
          </form>
        </div>


    </div> 

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
  </body>
</html>