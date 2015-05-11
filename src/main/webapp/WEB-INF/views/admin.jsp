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
        <h1>WELCOME TO ADMIN PAGE</h1>
        <div class="form-container">
          <<!-- Add Item Form-->
          <form action="">
            <h2 class="form-signin-heading">Add Item</h2>
            <label for="inputEmail" class="sr-only">Item Name</label>
            <input type="text" id="username" class="form-control" placeholder="Item Name" required="" autofocus="">
            <label for="inputPassword" class="sr-only">Item Description</label>
            <input type="text" id="itemDescription" class="form-control" placeholder="Item Description" required="">
            <label for="inputPassword" class="sr-only">Bid Duration</label>
            <input type="text" id="duration" class="form-control" placeholder="Bid Duration(Minutes)" required="">
            <label for="inputPassword" class="sr-only">Starting Bid</label>
            <input type="text" id="currentPrice" class="form-control" placeholder="Starting Bid" required="">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me"> Remember me
              </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
          </form>
        </div>


    </div> 

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
  </body>
</html>