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

    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/images/favicon.ico">
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css" rel="stylesheet">
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
            <button class="btn btn-lg btn-primary btn-block" id="addItem">Add Item</button>
          </div>
        </div>
        <div class="panel panel-primary col-md-12">
            <div class="panel-body">
                <table id="example" class="table table-hover" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th>itemName</th>
                    <th>itemDescription</th>
                    <th>duration</th>
                    <th>currentPrice</th>
                    <th>action</th>
                  </tr>
                </thead>
                <tbody>
                  
                </tbody>            
              </table>
          </div>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        
        <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Are you sure you want to delete <b ><span id="nameOfItem"></span></b> item?</h4>
                <input type="hidden" id="idOfItem">
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary" id="deleteItem">Yes</button>
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        
        <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Update <b ><span id="nameOfItem"></span></b> item?</h4>
                <input type="hidden" id="idOfItem">
              </div>
              <div class="modal-body">
                    <div class="panel panel-primary col-md-12">
                        <div class="panel-body">
                            <form >
                                <h2 class="form-signin-heading">Update Item</h2>
                                    <label for="itemName" class="sr-only">Item Name</label>
                                <input type="text" id="uitemName" class="form-control" placeholder="Item Name" required="" autofocus="">
                                    <label for="itemDescription" class="sr-only">Item Description</label>
                                <input type="text" id="uitemDescription" class="form-control" placeholder="Item Description" required="">
                                    <label for="duration" class="sr-only">Bid Duration</label>
                                <input type="text" id="uduration" class="form-control" placeholder="Bid Duration(hours)" required="">
                                    <label for="currentPrice" class="sr-only">Starting Bid</label>
                                <input type="text" id="ucurrentPrice" class="form-control" placeholder="Starting Bid" required="">
                            </form>
                      </div>
                    </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary" id="updateItem">UPDATE</button>
              </div>
            </div><!-- /.modal-content -->
          </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div> 
    
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function() {
            loadItems();
        });

       

        function loadItems() {
            $.get("getAllItems", function(data){
                //alert(data[0]["itemName"]);
                var tableData="";
                for(var i=0;i<data.length;i++){
                    tableData+=("<tr><td>"+data[i]["itemName"]+"</td>");
                    tableData+=("<td>"+data[i]["itemDescription"]+"</td>");
                    tableData+=("<td>"+data[i]["duration"]+"</td>");
                    tableData+=("<td>"+data[i]["createdAt"]+"</td>");
                    tableData+=("<td class='text-center'>"
                                    +"<button class='btn btn-warning btn-xs' data-toggle='modal' data-target='#updateModal' data-whatever='"+data[i]["itemID"]+"' ><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></button> "
                                    +"<button class='btn btn-danger btn-xs' data-toggle='modal' data-target='#exampleModal' data-whatever='"+data[i]["itemID"]+"' data-whatever2='"+data[i]["itemName"]+"' ><span class='glyphicon glyphicon-trash' aria-hidden='true'></span></button>"
                                +"</td></tr>");
                }

                $("tbody").html(tableData);
            });
        }

            $('#updateModal').on('show.bs.modal', function (event) {
              var button = $(event.relatedTarget);
              var itemID = button.data('whatever');
              
            

              $.get("getItemDataOf?itemID="+itemID, function(data, status){

                  selectedID=data["item"]["itemID"];

                  $("#uitemName").val("<b>Item ID</b>: "+data["item"]["itemName"]+"<br>");
                  $("#uitemDescription").val("<b>Item Name</b>: "+data["item"]["itemDescription"]+"<br>");
                  $("#uduration").val("<b>Posted on</b>: "+data["item"]["duration"]+"<br>");
                  $("#ucurrentPrice").val("<b>Description</b>: "+data["highestBid"]["price"]+"<br>");


                  $("#pot").attr("min", data["highestBid"]["price"] );
                  $("#pot").attr("value", data["highestBid"]["price"] );
                  //$("#modalBody").append("asd");
                  console.log(data["item"]["itemName"])
              });
            })
            $("#addItem").click(

                function(){
                    var arr = {
                        "userID": 1,  
                        "itemName": $("#itemName").val(), 
                        "itemDescription": $("#itemDescription").val(),
                        "duration": $("#duration").val(),
                        "price": $("#currentPrice").val()
                        }; 

                    $.ajax({
                        url: 'addItem' ,
                        type: 'POST',
                        data: JSON.stringify(arr),
                        contentType: 'application/json; charset=utf-8',
                        dataType: 'json'
                    }).done(function(data){
                        loadItems()
                        alert("Successfully Added Item ")
                    }).fail(function(data){
                        alert("Adding Failed:"+data);
                    });

            });

            $("#deleteItem").click(function(){
                    // $.get('deleteItem?itemID='+$("#idOfItem").val(), function(data, status){
                           
                    //         loadItems()

                    //         $("#exampleModal").modal('hide');
                    // });
                     $.ajax({
                        url: 'deleteItem?itemID='+$("#idOfItem").val(),
                        type: 'DELETE'
                    }).done(function(data){
                        //alert("success"+data)
                        loadItems();
                        $("#exampleModal").modal('hide');
                    }).fail(function(data){
                        alert("fail miserably"+data);
                    });
               
            });

            $("#deleteItem").click(function(){
                    // $.get('deleteItem?itemID='+$("#idOfItem").val(), function(data, status){
                           
                    //         loadItems()

                    //         $("#exampleModal").modal('hide');
                    // });
                     $.ajax({
                        url: 'deleteItem?itemID='+$("#idOfItem").val(),
                        type: 'DELETE'
                    }).done(function(data){
                        //alert("success"+data)
                        loadItems();
                        $("#exampleModal").modal('hide');
                    }).fail(function(data){
                        alert("fail miserably"+data);
                    });
               
            });
    </script>
  </body>
</html>