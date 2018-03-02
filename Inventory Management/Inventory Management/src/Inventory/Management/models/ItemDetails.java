package Inventory.Management.models;



public class ItemDetails {
	
	
	public float buyingPrice;
	public float sellingPrice;
	public int numOfItem;
	
	
	public ItemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDetails(float buyingPrice, float sellingPrice, int numOfItem) {
		super();
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.numOfItem = numOfItem;
	}
	public int getNumOfItem() {
		return numOfItem;
	}
	public void setNumOfItem(int numOfItem) {
		this.numOfItem = numOfItem;
	}
	public float getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return this.buyingPrice + ", " + this.sellingPrice + ", "+this.getNumOfItem() + "\n";
	}
	
}
