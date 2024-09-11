package Conn;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Product;

public class Connect {
	private static SessionFactory fac;
	
	public Connect() {
		fac= new Configuration().configure("hiber.config.xml").addAnnotatedClass(Product.class).buildSessionFactory();
	}
	
	public static SessionFactory getSessionFac() {
		Connect con=new Connect();
		return fac;
	}
}
