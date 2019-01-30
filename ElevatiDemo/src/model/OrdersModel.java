package model;

public class OrdersModel {
	private long orderID;
	private String title="";
	private String sku="";
	private String price="";
	//private boolean product_exists=true;
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	/*public boolean isProduct_exists() {
		return product_exists;
	}
	public void setProduct_exists(boolean product_exists) {
		this.product_exists = product_exists;
	}*/
}
