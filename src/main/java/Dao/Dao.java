package Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Conn.Connect;
import Model.Product;

public class Dao implements DaoInterf{
	
	Scanner sc=new Scanner(System.in);
	
	SessionFactory f;

	public Dao() {
		f = Connect.getSessionFac();
	}

	@Override
	public void addProduct(int prodId) {
		Session ses = f.openSession();
		try {
			Transaction tx = ses.beginTransaction();
	        String hql = "from Product p where p.prodId = :prodId";
	        Query q = ses.createQuery(hql);
	        q.setParameter("prodId", prodId);
	        
	        if (!q.getResultList().isEmpty()) {
	            System.out.println("Product already exists.");
	        }else {
	    		System.out.println("Enter product name:");
	    		String prodName=sc.nextLine();
	    			
	    		System.out.println("Enter the price:");
	    		Double prodPrice=sc.nextDouble();
	    		
	        	Product p=new Product();
	        	p.setProdId(prodId);
	        	p.setProdName(prodName);
	        	p.setPrice(prodPrice);
	        	ses.save(p);
	        	
	        	System.out.println("Product added Successfully!.");  	
	        }
	        tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteProduct(int prodId) {
		Session ses = f.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			String hql="delete from Product p where prodId=:prodId";
			Query q=ses.createQuery(hql);
			q.setParameter("prodId", prodId);
			
			int a=q.executeUpdate();
			tx.commit();
			if(a>0) {
				System.out.println("Product Removed!");
			}else {
				System.out.println("Product not found.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void changePrice(int prodId, Double newPrice) {
		Session ses = f.openSession();
		try {
			Transaction tx = ses.beginTransaction();
			String hql="update Product p set p.price=:newPrice where p.prodId=:prodId";
			Query q=ses.createQuery(hql);
			q.setParameter("newPrice", newPrice);
			q.setParameter("prodId", prodId);
			
			int a=q.executeUpdate();
			tx.commit();
			if(a>0) {
				System.out.println("Price updated!");
			}else {
				System.out.println("Product not found.");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void calculateBill(int prodId) {
		Session ses=f.openSession();
		try {
			Transaction tx=ses.beginTransaction();
			String hql="from Product p where prodId=:prodId";
			Query q=ses.createQuery(hql,Product.class);
			q.setParameter("prodId",prodId);
			List <Product> prodList=q.getResultList();
			
			if(!prodList.isEmpty()) {
				Product p=prodList.get(0);
				
				System.out.println("Enter the quantity");
				int qty=sc.nextInt();
				
				Double totalBill=qty*p.getPrice();
				System.out.println("The total bill is "+totalBill);
			}else {
				System.out.println("Product Not Found");
			}
			
			tx.commit();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
