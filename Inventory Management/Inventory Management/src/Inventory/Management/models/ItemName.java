package Inventory.Management.models;

import Inventory.Management.InventoryManage;

public class ItemName {
	public String nameOfItem;

	public ItemName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemName(String nameOfItem) {
		super();
		this.nameOfItem = nameOfItem;
	}
	
	
	public String getNameOfItem() {
		return nameOfItem;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

	@Override
	public boolean equals(Object arg0) {
		ItemName i = (ItemName)arg0;
	return 	this.nameOfItem.equals(i.nameOfItem);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.nameOfItem.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nameOfItem;
	}

}
