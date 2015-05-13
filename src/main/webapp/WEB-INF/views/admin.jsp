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
        <h1>ADMIN PAGE</h1>
        <div class="panel panel-primary col-md-12">
            <div class="panel-body">
                <form >
                    <h2 class="form-signin-heading">Add Item</h2>
                        <label for="itemName" class="sr-only">Item Name</label>
                    <input type="text" id="itemName" class="form-control" placeholder="Item Name" required="" autofocus="">
                        <label for="itemDescription" class="sr-only">Item Description</label>
                    <input type="text" id="itemDescription" class="form-control" placeholder="Item Description" required="">
                        <label for="duration" class="sr-only">Bid Duration</label>
                    <input type="text" id="duration" class="form-control" placeholder="Bid Duration(hours)" required="">
                        <label for="currentPrice" class="sr-only">Starting Bid</label>
                    <input type="text" id="currentPrice" class="form-control" placeholder="Starting Bid" required="">
                </form>
            <button class="btn btn-lg btn-primary btn-block" id="gogo">Add Item</button>
          </div>
        </div>
        <div class="panel panel-primary col-md-12">
            <div class="panel-body">
                <table id="example" class="table table-hover" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th>itemID</th>
                    <th>itemName</th>
                    <th>userID</th>
                    <th>itemDescription</th>
                    <th>duration</th>
                    <th>currentPrice</th>
                    <th>createdAt</th>
                    <th>highestBidder</th>
                    <th>highestBidderID</th>
                  </tr>
                </thead>
                <tbody>
                  
                </tbody>            
              </table>
          </div>
        </div>


    </div> 
    
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script>

        $(document).ready(function() {
            $.get("getAllItems", function(data, status){
                //alert(data[0]["itemName"]);
                var tableData="";
                for(var i=0;i<data.length;i++){
                    tableData+=("<tr><td>"+data[i]["itemID"]+"</td>");
                    tableData+=("<td>"+data[i]["itemName"]+"</td>");
                    tableData+=("<td>"+data[i]["userID"]+"</td>");
                    tableData+=("<td>"+data[i]["itemDescription"]+"</td>");
                    tableData+=("<td>"+data[i]["duration"]+"</td>");
                    tableData+=("<td>"+data[i]["currentPrice"]+"</td>");
                    tableData+=("<td>"+data[i]["createdAt"]+"</td>");
                    tableData+=("<td>"+data[i]["highestBidder"]+"</td>");
                    tableData+=("<td>"+data[i]["highestBidderID"]+"</td>");
                    tableData+=("<td><a class='btn btn-default' href='user/placeBid' role='button'>BID</a></td></tr>");
                }
                $("tbody").html(tableData);
            });
        });
            $("button").click(

                function(){
                    var arr = {
                        "userID": 1,  
                        "itemName": $("#itemName").val(), 
                        "itemDescription": $("#itemDescription").val(),
                        "duration": $("#duration").val(),
                        "currentPrice": $("#currentPrice").val()
                        }; 

                    $.ajax({
                        url: 'addItem',
                        type: 'POST',
                        data: JSON.stringify(arr),
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json'
                    }).done(function(data){

                    }).fail(function(data){
                        alert("fail miserably"+data);
                });

            });

            

    </script>
  </body>
</html>