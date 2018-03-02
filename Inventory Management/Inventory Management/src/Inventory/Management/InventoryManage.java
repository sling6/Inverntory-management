package Inventory.Management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import Inventory.Management.models.ItemDetails;
import Inventory.Management.models.ItemName;

public class InventoryManage {
	
   public static HashMap<ItemName, ItemDetails> ItemStore = new HashMap<ItemName, ItemDetails>();
   public static float profit = (float) 0.0;
   
	public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		String command;
		
		System.out.println("**************Inventory Management************");
		
		while(exit == false) {
			String[] op;
			
			command =  scan.readLine();
			op = command.split(" ");
			//System.out.println(Arrays.asList(op)); // method 1
			if(op[0].equals("#")) {
				exit = true;
				 scan.close();
				System.out.print("**************Inventory Management Closed************");
				System.out.println();
				
			}else if(op[0].equals("create")){
				//System.out.print(" Given command =====>" + command);
				
				ItemDetails x = ItemStore.putIfAbsent(new ItemName(op[1]), new ItemDetails(new Float(op[2]),new Float(op[3]),0))  ;
				 
				 if(x == null) {
					 System.out.print("*item added*");
				 }else {
					 System.out.print("<item already exits>");
				 }
			}else if(op[0].equals("delete")){
				//System.out.print(" Given command =====>" + command);
				
				ItemDetails x = ItemStore.remove(new ItemName(op[1]))  ;
				 
			}else if(op[0].equals("updateSell")){
				//System.out.print(" Given command =====>" + command);
				
				int presentCount = ItemStore.get(new ItemName(op[1])).numOfItem  ;
				 
				 if(presentCount - new Integer( op[2]) < 0) {
					 System.out.print("Invalid Sell update");
				 }else {
					 ItemStore.get(new ItemName(op[1])).numOfItem = presentCount - new Integer( op[2]);
					  profit = profit + new Integer( op[2])*(ItemStore.get(new ItemName(op[1])).sellingPrice - ItemStore.get(new ItemName(op[1])).buyingPrice);
				 }
			}else if(op[0].equals("updateBuy")){
				//System.out.print(" Given command =====>" + command);
				
				int presentCount = ItemStore.get(new ItemName(op[1])).numOfItem ;
				 ItemStore.get(new ItemName(op[1])).numOfItem = presentCount + new Integer( op[2]); 
			}else if(op[0].equals("report")){
				float total = 0;
				
				System.out.println("\n");
				System.out.printf("%40s", "INVENTORY REPORT\n");
		    	System.out.printf("%-15s%15s%15s%15s%15s", "Item Name","Bought At","Sold At","AvailableQty","Value\n");
		    	System.out.printf("%-15s%15s%15s%15s%15s", "---------","---------","-------","------------","-----\n");
		    	for (ItemName key : ItemStore.keySet()) {
		    		ItemDetails index = ItemStore.get(key)  ;
		    		total = total +index.buyingPrice * (float)index.numOfItem;
		    		System.out.printf("%-15s%15.2f%15.2f%15d%15.2f",key.nameOfItem,
		    				                                                index.buyingPrice,
		    				                                                index.sellingPrice,
		    				                                                index.numOfItem,
		    				                                                (index.buyingPrice * (float)index.numOfItem)
		    				                                                );
		    		System.out.println();
		    	}
		    	System.out.println("----------------------------------------------------------------------------------");
		    	System.out.printf("%-60s%15.2f", "Total value",total);
		    	System.out.println();
		    	System.out.printf("%-60s%15.2f", "Profit since previous report",profit);
			}
			
		}
		
	
	}

}
