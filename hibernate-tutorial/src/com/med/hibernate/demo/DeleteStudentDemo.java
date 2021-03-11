package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//delete the student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			//delete the student id of 2
			System.out.println("Deleting student id=2 ");
			session.createQuery("delete from Student where id=2").executeUpdate();
						
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
