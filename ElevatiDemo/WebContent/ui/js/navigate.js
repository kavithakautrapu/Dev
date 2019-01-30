function showOrders(){
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}
	else{
	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
			
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var json;
			json = JSON.parse(xmlhttp.responseText);
			//if(json.success==true){
				var content = json.allOrders;
				//Set table heading
				var display = "<table width=\"100%\" style=\"border:2px solid blue;\">" +
						"<tr style=\"border:2px solid blue;background-color:#85c1e9;\"><th>Order ID</th>" +
						"<th>Title</th>" +
						"<th>SKU</th>" +
						"<th>Price</th></tr>";
				
				//generate rows of table
				for(i=0;i<content.length;i++){
					display += "<tr><td>"+content[i].OrderID+"</td>";
					display += "<td>"+content[i].title+"</td>";
					display += "<td>"+content[i].sku+"</td>";
					display += "<td>"+content[i].price+"</td></tr>";
				}
				display += "</table>";
				document.getElementById("orders").innerHTML = display;
			/*}else{
				alert("Problem in fetching details.");
			}	*/
		}
	}	
	xmlhttp.open("GET","/ElevatiDemo/displayOrders",true);
	//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	//xmlhttp.setRequestHeader("Connection", "close");
	xmlhttp.send();	
}