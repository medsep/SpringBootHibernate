package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session		
		Session session = factory.getCurrentSession();
		//use session object to save
		try {
			
			int studentId = 1;
						
			//get a new session for reading
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on ID/PK
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student ...");
			myStudent.setFirstName("Moody");
			session.getTransaction().commit();
				
			//new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Updating email for all students");
			
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
