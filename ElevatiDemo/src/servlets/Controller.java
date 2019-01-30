package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import dao.OrdersDAO;
import model.OrdersModel;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public static void main(String args[]) {
		
	}
    public Controller() {
        super();
     }
    
   @Override 
public void init() {
	   CallAPI ca = new CallAPI();
		try {
			ca.callingAPI();
		} catch (ClassNotFoundException | ParseException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("In Controller");
	
	
}
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		/*if(requestURI.contains("/fetchOrders")) {
			}else*/ 
				
		PrintWriter out = response.getWriter();
			
			if(requestURI.contains("/displayOrders")) {				
			List<OrdersModel> orders = new ArrayList<OrdersModel>();
			OrdersDAO od = new OrdersDAO();
			JSONArray ordarray = new JSONArray();
			JSONObject jsonOrders = new JSONObject();
			
			try {
				orders = od.retrieveOrders();
				for(OrdersModel o: orders) {
					
					JSONObject oobj = new JSONObject();
					oobj.put("OrderID",o.getOrderID());
					oobj.put("title", o.getTitle());
					oobj.put("sku", o.getSku());
					oobj.put("price", o.getPrice());
					//oobj.put("product_exists", o.isProduct_exists());
					ordarray.add(oobj);
				}
			jsonOrders.put("allOrders", ordarray);
			//jsonOrders.put("success", true);
			//req.setAttribute("new", jsonOrders);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally{
				out.write(jsonOrders.toString());
			}	
			
			//req.getRequestDispatcher("/ui/jsp/orders.jsp").forward(req, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
