<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="<%=request.getContextPath()%>/ui/js/navigate.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>

<head>
<title>Home</title>
</head>
<body>
<div style="align:center" width="100%">
<h1>Welcome to Shopify!!</h1>

<input type="button" id="showOrders" name="showOrders"  onclick='showOrders()' value="Show Orders"/> 

<div id="orders" style="align:center;width:100%" width="100%"></div>


<!-- <form id="callOrders" action="/displayOrders" >
	<input type="button" id="showOrders" name="showOrders" value="Show Orders"/>
</form> -->

</div>
</body>

</html>