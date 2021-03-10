package com.med.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session		
		Session session = factory.getCurrentSession();
		//use session object to save
		try {
						
			//start a transaction
			session.beginTransaction();
			
			//query db
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display db
			displayStudents(theStudents);
			
			//query students: lastName = Duck
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			//display the results
			System.out.println("\n\nStudents with last name Duck");
			displayStudents(theStudents);
			
			//query lastname="Duck: or firstName = "Mary"
			theStudents = session.createQuery("from Student s where s.lastName = 'Duck' OR s.firstName = 'Mary'").list();
			System.out.println("\nEmail ends with last name Duck or first name Mary");
			displayStudents(theStudents);
			
			//query studnets where email like %gmail.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%hmail.com'").list();
			System.out.println("\nEmail ends with gmail.com");
			displayStudents(theStudents);
			
			//committ tranaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
