package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Instructor;
import com.med.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session		
		Session session = factory.getCurrentSession();
		
		//use session object to save
		try {
			//start a transaction
			session.beginTransaction();
			
			//get instructor detail
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//priunt instructor detail
			System.out.println("tempInstructor detials: " +tempInstructorDetail );
			
			//print associated instructor
			System.out.println("The asociated instructor: " + tempInstructorDetail.getInstructor());			
			
			//committ tranaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}catch (Exception exc) {
			exc.printStackTrace();
		}		
		finally {
			//handle leak issue
			session.close();
			factory.close();
		}

	}

}
