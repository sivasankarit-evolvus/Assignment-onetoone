package com.demo;

import java.sql.Date;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateMavenApplication {

	static User userObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 

	public static void main(String[] args) {
		SpringApplication.run(HibernateMavenApplication.class, args);
		System.out.println("Hibernate one to one (Annotation)");
		Session session = Util.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("1001");
		stock.setStockName("Soap");

		StockDetail stockDetail = new StockDetail();
		
		stockDetail.setCompName("Hamam");
		stockDetail.setCompDesc("Hindustan manufacturer");
		stockDetail.setRemark("veg oil soap");
		stockDetail.setListedDate(new Date(System.currentTimeMillis()));
		stockDetail.setStock(stock);
		stock.setStockDetail(stockDetail);
		
		
		
		session.save(stock);
		//session.save(stockDetail);
		
		session.getTransaction().commit();

		System.out.println("Done");
		
	}

}
