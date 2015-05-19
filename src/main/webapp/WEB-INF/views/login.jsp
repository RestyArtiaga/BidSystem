<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <title>Bidding System - Login</title>

    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/images/favicon.ico">
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/override.css" rel="stylesheet">

  </head>
  <body>
    <div class="login-container">

      <form class="form-signin" action="<c:url value='/j_spring_security_check' />" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required  autofocus >
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password"  name="password" class="form-control" placeholder="Password" required >        
        <div class="checkbox">
            <a type="checkbox" href="<c:url value='/formRegister' />" >Register</a>
        </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> 

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script>

           /*  $("button").click(

                function(){
                    var arr = {    
                        "itemName": $("#itemName").val(), 
                        "itemDescription": $("#itemDescription").val(),
                        "duration": $("#duration").val(),
                        "currentPrice": $("#currentPrice").val()
                        }; 

                    $.ajax({
                        url: 'register',
                        type: 'POST',
                        data: JSON.stringify(arr),
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json'
                    }).done(function(data){

                    }).fail(function(data){
                        alert("fail miserably"+data);
                });

            }); */
           
    </script>
  </body>
</html>