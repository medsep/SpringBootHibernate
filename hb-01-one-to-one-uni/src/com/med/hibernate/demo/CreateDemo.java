package com.med.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.med.hibernate.demo.entity.Instructor;
import com.med.hibernate.demo.entity.InstructorDetail;
import com.med.hibernate.demo.entity.Student;

public class CreateDemo {

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
			//create objects
			/*Instructor tempInstructor = new Instructor("Med", "Sepa", "sepa@email.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.medsep.com/youtube","Loves life!!!");*/
			
			//create objects
			Instructor tempInstructor = new Instructor("Medi", "Sepah", "sepah@email.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.medisepa.com/youtube","Loves Java!!!");
			
			//asscoaite objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save a session and baecause cascade it will save all associated objects
			System.out.println("Saving the instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//committ tranaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
