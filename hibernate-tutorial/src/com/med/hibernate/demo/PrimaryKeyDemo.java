package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		// create session factory
				SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create a session		
				Session session = factory.getCurrentSession();
				//use session object to save
				try {
					//create 3 student object
					System.out.println("Creating 3 new student object...");
					Student tempStudent1 = new Student("Mike", "Hall", "ced.sep@gmail.com");
					Student tempStudent2 = new Student("Mary", "Mall", "ped.sep@gmail.com");
					Student tempStudent3 = new Student("Luke", "Call", "ked.sep@gmail.com");
					
					//start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//committ tranaction
					session.getTransaction().commit();
					System.out.println("Done!");
					
				}finally {
					factory.close();
				}

	}

}
