<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
    <title>Bidding System</title>

    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/override.css" rel="stylesheet">

  </head>
  <body>
    <div class="container">
      <header>
            <nav class="navbar navbar-default">
            <div class="container-fluid danger">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Bidding System</a>
                
              </div>
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     
      
                  <ul class="nav navbar-nav navbar-right">
                    <li><a href="formLogin">Sign In</a></li>
                    
                  </ul>
                </div>
            </div>
        </nav>        
      </header>
      <main>
        <div class="panel panel-primary">
          <div class="panel-heading">Item Detail</div>
          <div class="panel-body">
            asd
          </div>          
        </div>
      </main>
    </div><!-- /container -->

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" class="init">
      $(document).ready(function() {
           $.get("getAllItems", function(data, status){
              //alert(data[0]["itemName"]);	
              var tableData="";
              for(var i=0;i<data.length;i++){
                tableData+=("<tr><td><a href='getItemDataOf?itemID="+data[i]["itemID"]+"'>"+data[i]["itemName"]+"</a></td>");
                tableData+=("<td>"+data[i]["itemDescription"]+"</td>");
                tableData+=("<td>"+data[i]["duration"]+"</td>");
                tableData+=("<td>"+data[i]["currentPrice"]+"</td>");
                tableData+=("<td class='text-center'><a class='btn btn-success btn-xs' href='placeBid' role='button'><span class='glyphicon glyphicon-bullhorn' aria-hidden='true'></span> BID</a></td></tr>");
              }
              $("tbody").html(tableData);
          });
      } );
      

    </script>
  </body>
</html>