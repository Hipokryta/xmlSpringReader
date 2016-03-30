<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bluesoft.resources.JqueryDatatablePlugin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

	var path = '${pageContext.request.contextPath}';
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap
/3.2.0/css/bootstrap.min.css">
<link href="http://cdn.datatables.net/1.10.3/css/jquery.dataTables.css" rel="stylesheet"
 type="text/css">
 
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://cdn.datatables.net/1.10.3/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<h1> First Spring </h1>
	<h2>${welcomeMessage} </h2>
	<form method="post" enctype="multipart/form-data" action="uploadFile.do">
		Upload File: <input type="file" name="file">
		<br /><br />
		Description: <input type="text" name="name"/>
		<br/><br/><input type="submit" value="Upload"> 
	</form>
	<form>
 <div class="form">
  <table width="100%" border="0" margin="0" padding="0"
   class="row-border tableHeader" id="personTable">
   <thead>
    <tr>
        <th>Id</th>
     <th>active</th>
     <th>amount</th>
     <th>amount period</th>
     <th>amount type</th>
     <th>authorization percent</th>
     <th>from date</th>
     <th>order number</th>
     <th>request</th>
     <th>to date</th>
     <th>system id</th>
    </tr>
   </thead>
   <tbody>
   </tbody>
  </table>
 </div>
</form>
	<style>
tfoot input {
        width: 100%;
        padding: 3px;
        box-sizing: border-box;
    }
.tableHeader{
text-align:left;
}
tfoot {
    display: table-header-group;
}
.dataTables_length
{
position: absolute;
    top: 10px;
    left: 220px;
}
.dataTables_info {
    position: absolute;
    top: 0px;
    left: 5px;
}
.ColVis{
 padding-right:10px;
 padding-top:5px;
 
}
.dataTables_filter {
   position: absolute;
   top: 10px;
   left: 200px;
   font-size:15px;
}
.dataTables_filter input{
height:22px;
width:150px
}
input
{
-moz-border-radius: 15px;
 border-radius: 3px;
 border:solid 1px #c7c7c7;
 padding:5px;
}
table.dataTable tbody td {
    padding: 5px;
    padding-left: 20px;
}
</style>
<script type="text/javascript">
var table;

jQuery(document).ready(function() {
	
	$("#personTable").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sAjaxSource": "/BlueSoft/AjaxDataSource",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "id" },
            { "mData": "active" },
            { "mData": "amount" },
            { "mData": "amount_period" },
            { "mData": "amount_type" },
            { "mData": "auth" },
            { "mData": "from_date" },
            { "mData": "order_number" },
            { "mData": "request" },
            { "mData": "to_date" },
            { "mData": "system_id" }
            
        ]    } )
     
   $("#personTable_length").hide();
   $("div.toolbar").append('<div class="btn-group" style="padding:5px "><button class="btn btn-default" id="refreshbtn" style="background:none;border:1px solid #ccc;height:30px" type="button"><span class="glyphicon glyphicon-refresh" style="padding:3px"></span></button></div>');
      $("div.toolbar").css("float","right");
      $('#refreshbtn').click(function(){
       table.fnStandingRedraw();
     });
    
 
 });
 </script>
</body>
</html>