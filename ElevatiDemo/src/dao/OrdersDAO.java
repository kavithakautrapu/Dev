package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.OrdersModel;

public class OrdersDAO {
	
	public Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver"); 
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ElevatiDemo", "root", "root");
		return con;
	}
	
	List<OrdersModel> orders = new ArrayList<OrdersModel>();
		
	public void insertOrders(OrdersModel omd) throws SQLException, ClassNotFoundException {
		Connection con = init();
		PreparedStatement ps=con.prepareStatement("insert into orders values(?,?,?,?);");  
				ps.setLong(1,omd.getOrderID()); 
				ps.setString(2, omd.getTitle());
				ps.setString(3, omd.getSku());
				ps.setFloat(4, omd.getPrice());
				//ps.setBoolean(5, omd.isProduct_exists());
			ps.executeUpdate();
			
			con.close();
	}	
	public List<OrdersModel> retrieveOrders() throws SQLException, ClassNotFoundException {
		Connection con = init();
		
		Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from orders;");  
			while(rs.next())  {
				OrdersModel om = new OrdersModel();
				om.setOrderID(rs.getLong("OrderID"));
				om.setTitle(rs.getString("title"));
				om.setSku(rs.getString("sku"));
				om.setPrice(rs.getFloat("price"));
				//om.setProduct_exists(rs.getBoolean("product_exists"));
				orders.add(om);
			}
			con.close();
			
		return orders; 
		
		}
}
