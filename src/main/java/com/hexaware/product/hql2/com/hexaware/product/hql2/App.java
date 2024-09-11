package com.hexaware.product.hql2.com.hexaware.product.hql2;

import java.util.Scanner;

import Service.Service;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
		Service s=new Service();
    	
		while(true)
		{
			System.out.println("1. Add New Item");
			System.out.println("2. Remove Item");
			System.out.println("3. Update Price");
			System.out.println("4. Calculate Bill");
			System.out.println("5. Exit");
			int ch=sc.nextInt();
			
			if(ch==1)
			{
				s.addItem();
			}
			else if(ch==2)
			{
				s.removeItem();
			}
			else if(ch==3)
			{
				s.updatePrice();
			}
			else if(ch==4)
			{	
				s.calBill();
			}
			else if(ch==5)
			{
				break;
			}
			else
			{
				System.out.println("Invalid input");
				continue;
			}
			
		}
    }
}
