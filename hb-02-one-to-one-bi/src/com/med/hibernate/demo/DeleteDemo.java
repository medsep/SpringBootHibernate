package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Instructor;
import com.med.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			//session = factory.getCurrentSession();
			session.beginTransaction();
			
			//get instructor by PK
			int theId=1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructors: "+ tempInstructor);
			
			//delete the instructor
			if (tempInstructor!=null) {
				System.out.println("Deleting: " + tempInstructor);
			
				//also deletes the associated object due to cascading
			session.delete(tempInstructor);
			}				
			//committ tranaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
