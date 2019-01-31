package testUnit;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;

import dao.OrdersDAO;
import model.OrdersModel;

public class Test {
	 
	   public void testCase() throws ClassNotFoundException, SQLException {
		   OrdersDAO od = new OrdersDAO();
		   OrdersModel omd = new OrdersModel();
			
			 omd.setOrderID(1558721222);
			 omd.setTitle("650C 45mm Micro Wheelset");
			 omd.setSku("Orange Wheels 650c");
			 omd.setPrice(130);
			 
			 od.insertOrders(omd);
			 
			 System.out.println("Test case successful");		
				
			}
 public static void main(String[] args) throws ClientProtocolException, IOException {
	 Test t = new Test();
	 try {
		 
		t.testCase();
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
				
	} catch (SQLException e) {
		e.printStackTrace();
			
	}
	
 }
 

}


