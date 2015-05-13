<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <title>Bidding System - Register</title>

    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/override.css" rel="stylesheet">

  </head>
  <body>
    <div class="login-container">

      <form>
        <h2 class="form-signin-heading">Register New User</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="text" id="username" class="form-control" placeholder="Username" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" required>
        <label for="inputPassword2" class="sr-only">Password</label>
        <input type="password" id="password2" class="form-control" placeholder="Verify Password" required>
        
        
      </form>
        <button class="btn btn-lg btn-primary btn-block" id="submit">Register</button>
    </div> 


    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script>

            $("#submit").click(
                function(){
                    $.get("isUsernameExisting?username="+$("#username").val(), function(data, status){
                        if(data==false){
                          //alert("pwede");
                          if($("#password").val()==$("#password2").val()&&$("#password").val()!=""&&$("#password2").val()!=""){
                               var arr = {    
                                    "username": $("#username").val(), 
                                    "password": $("#password2").val(),
                                    "roleID":2
                                    }; 
                                $.ajax({
                                    url: 'register',
                                    type: 'POST',
                                    data: JSON.stringify(arr),
                                    contentType: 'application/json; charset=utf-8',
                                    dataType: 'json'
                                }).done(function(data){
                                    alert("You have successfully registered!");

                                window.location.href = "formLogin";
                                }).fail(function(data){
                                    alert("Failed"+data);
                                });
                          }
                          else{
                            alert("Make sure you typed the the correct password.");
                          }
                        }
                        else{

                          alert("username already exist!");
                        }
                    });
                    // var arr = {    
                    //     "username": $("#username").val(), 
                    //     "password": $("#password2").val(),
                    //     "role"
                    //     }; 
                    // $.ajax({
                    //     url: 'register',
                    //     type: 'POST',
                    //     data: JSON.stringify(arr),
                    //     contentType: 'application/json; charset=utf-8',
                    //     dataType: 'json'
                    // }).done(function(data){
                    //     alert("success"+data);
                    // }).fail(function(data){
                    //     alert("fail miserably"+data);
                    // });
            });
    </script>
  </body>
</html>