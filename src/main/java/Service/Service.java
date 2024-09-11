package Service;

import java.util.Scanner;

import Dao.Dao;

public class Service {
Scanner sc=new Scanner(System.in);
	
	public void addItem() {
		System.out.println("Enter the product ID:");
		int prodId=sc.nextInt();
		sc.nextLine();
		
		Dao dao=new Dao();
		dao.addProduct(prodId);			
	}
	
	public void removeItem() {
		System.out.println("Enter the product ID");
		int prodId=sc.nextInt();
		
		Dao dao=new Dao();
		dao.deleteProduct(prodId);
	}
	
	public void updatePrice() {
		Dao dao=new Dao();
		System.out.println("Enter the product ID");
		int prodId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the new price:");
		Double newPrice=sc.nextDouble();
		
		dao.changePrice(prodId,newPrice);
	}
		
	public void calBill() {
		Dao dao=new Dao();
		System.out.println("Enter the product ID");
		int prodId=sc.nextInt();
		sc.nextLine();
		dao.calculateBill(prodId);
	}
	
	
}
