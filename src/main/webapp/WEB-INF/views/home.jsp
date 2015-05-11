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

    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/assets/css/override.css" rel="stylesheet">

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
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">home <span class="sr-only">(current)</span></a></li>
                 
                </ul>
                <form class="navbar-form navbar-right" role="search">
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username">
                    <input type="password" class="form-control" placeholder="Password">
                  </div>
                  <button type="submit" class="btn btn-primary">Login</button>
                </form>
              </div>
            </div>
        </nav>        
      </header>
      <main>
        <div class="panel panel-primary">
          <div class="panel-heading">Item Lists</div>
          <table class="table">
              <tr>
                <th>#</th>
                <th>Item Name</th>
                <th>Item Description</th>
                <th>Remaining Time</th>
                <th>Highest Bidder</th>
                <th>Current Bid</th>
                <th>Actions</th>
              </tr>
              <tr>
                <td>1</td>
                <td>laptop</td>
                <td>Very new</td>
                <td>1 week</td>
                <td>Inah</td>
                <td>$400</td>
                <td><button type="button" class="btn btn-success btn-xs">Bid on this item</button></td>
              </tr>
          </table>
          </div>
      </main>
    </div><!-- /container -->

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
  </body>
</html>