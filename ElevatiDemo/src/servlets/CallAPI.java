package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.OrdersDAO;
import model.OrdersModel;


public class CallAPI {
	
	public void callingAPI()throws ClientProtocolException, IOException, ParseException, SQLException, ClassNotFoundException{
	  OrdersDAO dao = new OrdersDAO();
	  
	  HttpClient client = new DefaultHttpClient();
	  HttpGet request = new HttpGet("http://elevatitech.com/api/test/shopify/orders");
	  HttpResponse response = client.execute(request);
	  
	  String con = EntityUtils.toString(response.getEntity());

	  JSONParser parse = new JSONParser();
	  
	  JSONObject myObject = (JSONObject)parse.parse(con);
	  //JSONArray status = (JSONArray) myObject.get("success");
	  
	  //if(status.toString().equalsIgnoreCase("true")) {
		  JSONArray data = (JSONArray) myObject.get("data");
		  System.out.println("data value.."+data);
		  
		  for(int i=0;i<data.size();i++) {
			  OrdersModel om = new OrdersModel();
			  JSONObject details = (JSONObject) data.get(i);
			  System.out.println("details value.."+details);
			  
			  JSONArray line_items = (JSONArray) details.get("line_items");
			  System.out.println("line_items value.."+line_items);
			  
			  for(int j=0;j<line_items.size();j++) {
				  JSONObject order_data = (JSONObject) line_items.get(0);
				  System.out.println("order_data value.."+order_data);
				  
				  om.setOrderID((long) order_data.get("id"));
				  om.setTitle((String)order_data.get("title"));
				  om.setPrice((String)order_data.get("price"));
				  om.setSku((String)order_data.get("sku"));			  
				  //om.setProduct_exists((boolean)order_data.get("product_exists"));		
				  break;
			  }
			  dao.insertOrders(om);
		  }
	 // }
	}
}
