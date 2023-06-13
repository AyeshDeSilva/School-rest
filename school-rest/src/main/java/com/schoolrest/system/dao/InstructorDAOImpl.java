package com.schoolrest.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoolrest.system.entity.Course;
import com.schoolrest.system.entity.Instructor;



@Repository
public class InstructorDAOImpl implements InstructorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Instructor> getInstructors() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Instructor> theQuery = currentSession.createQuery("from Instructor", Instructor.class);

		List<Instructor> instructors = theQuery.getResultList();

		return instructors;
	}

	@Override
	public void saveInstructor(Instructor theInstructor) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theInstructor);

	}

	@Override
	public Instructor getInstructor(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Instructor theInstructor = currentSession.get(Instructor.class, theId);

		return theInstructor;
	}

	@Override
	public void deleteInstructor(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Instructor where id=:instructorId");

		theQuery.setParameter("instructorId", theId);

		theQuery.executeUpdate();

	}
	
	@Override
	public Instructor addCourse(int instructorId, int courseId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Instructor instructor = currentSession.get(Instructor.class, instructorId);

		Course course = currentSession.get(Course.class, courseId);

		instructor.addCourse(course);

		return instructor;

	}

	@Override
	public void removeCourse(int instructorId, int courseId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Instructor instructor = currentSession.get(Instructor.class, instructorId);

		for (Course courses : instructor.getCourses()) {
			if (courses.getId() == courseId) {
				courses.setInstructor(null);
			}
		}

	}

	

}
