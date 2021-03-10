package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session		
		Session session = factory.getCurrentSession();
		//use session object to save
		try {
			//create student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Daffy", "Duck", "daffy.duck@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//committ tranaction
			session.getTransaction().commit();
			
			//new code for reading
			//find students' id:PK
			System.out.println("Saved student. Generated id:" + tempStudent.getId());			
			System.out.println("Done!");
			
			//get a new session for reading
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on ID/PK
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
