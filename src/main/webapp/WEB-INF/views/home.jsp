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
          <div class="panel-heading">Item Lists</div>
          <table id="example" class="table table-hover" >
            <thead>
              <tr>
                <th>Item Name</th>
                <th>Item Description</th>
                <th>Duration</th>
                <th>Posted on:</th>
                <th class='text-center' >action</th>
              </tr>
            </thead>
            <tbody>
              
            </tbody>            
          </table>
          </div>
        
      </main>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalTitle">Modal title</h4>
              </div>
              <div class="modal-body"  id="modalBody">
                <div class="panel panel-default">
                  <div class="panel-body" id="itemDetails">
                    
                  </div>
                </div>
                <div class="panel panel-default">
                  <div class="panel-body" id="bidDetails">
                    
                  </div>
                </div>
                <div class="panel panel-default">
                  <div class="panel-body" id="bidpot">
                   <h2> Bid: <input id="pot" type="number" min="500"/></h2>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="submitBid">Submit Bid</button>
              </div>
            </div>
          </div>
        </div>
    </div><!-- /container -->

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" class="init">
      var selectedID=0;
      $(document).ready(function() {

            

            $('#myModal').on('show.bs.modal', function (event) {
              var button = $(event.relatedTarget);
              var itemID = button.data('itemid');
              
            

              $.get("getItemDataOf?itemID="+itemID, function(data, status){

                  selectedID=data["item"]["itemID"];
                  $("#modalTitle").html("Bid on <b>"+data["item"]["itemName"]+"</b>");
                  $("#itemDetails").text("");
                  $("#itemDetails").append("<b>Item ID</b>: "+data["item"]["itemID"]+"<br>");
                  $("#itemDetails").append("<b>Item Name</b>: "+data["item"]["itemName"]+"<br>");
                  $("#itemDetails").append("<b>Posted on</b>: "+data["item"]["createdAt"]+"<br>");
                  $("#itemDetails").append("<b>Description</b>: "+data["item"]["itemDescription"]+"<br>");


                  $("#bidDetails").text("");
                  $("#bidDetails").append("<b>Last bid</b>: $"+data["highestBid"]["price"]+"<br>");
                  $("#bidDetails").append("<b>Last bidder</b>: "+data["highestBid"]["userID"]["username"]+"<br>");
                  $("#bidDetails").append("<b>submitted on</b>: "+data["highestBid"]["createdAt"]+"<br>");

                  $("#pot").attr("min", data["highestBid"]["price"] );
                  $("#pot").attr("value", data["highestBid"]["price"] );
                  //$("#modalBody").append("asd");
                  console.log(data["item"]["itemName"])
              });
            })

            $("#submitBid").click(function() {

                  console.log(selectedID)
                    var arr = {
                        "itemID": selectedID,  
                        "userID": 1, 
                        "price":  $("#pot").val()
                        }; 

                    $.ajax({
                        url: 'placeBid',
                        type: 'POST',
                        data: JSON.stringify(arr),
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json'
                    }).done(function(data){
                        //alert("success"+data)
                        loadItems();
                        $("#myModal").modal('hide');
                    }).fail(function(data){
                        alert("fail miserably"+data);
                    });
            });

            loadItems();
          
      } );

  function loadItems(){
     $.get("getAllItems", function(data, status){
              //alert(data[0]["itemName"]); 
              var tableData="";
              for(var i=0;i<data.length;i++){
                tableData+=("<tr><td>"+data[i]["itemName"]+"</td>");
                tableData+=("<td>"+data[i]["itemDescription"]+"</td>");
                tableData+=("<td>"+data[i]["duration"]+"</td>");
                tableData+=("<td>"+data[i]["createdAt"]+"</td>");
                tableData+=("<td class='text-center'><button type='button' class='btn btn-primary btn-xs' data-toggle='modal' data-target='#myModal' data-itemID="+data[i]["itemID"]+" ><span class='glyphicon glyphicon-bullhorn' aria-hidden='true'></span> BID</button></td></tr>");
              }
              $("tbody").html(tableData);
          });
  }
    </script>
  </body>
</html>