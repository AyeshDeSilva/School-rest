package com.schoolrest.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoolrest.system.entity.Student;
import com.schoolrest.system.entity.Course;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudent() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		
		List<Student> student = theQuery.getResultList();
		
		return student;
	}

	@Override
	public void saveStudent(Student theStudent) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStudent);
		
	}

	@Override
	public Student getStudent(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student theStudent = currentSession.get(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		
		theQuery.setParameter("studentId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public Student addCourse(int studentId, int courseId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = currentSession.get(Student.class, studentId);
		
		Course course = currentSession.get(Course.class, courseId);
		
		student.addCourse(course);
				
		return student;
	}
	
	@Override
	public void removeCourse(int studentId, int courseId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = currentSession.get(Student.class, studentId);
		
		for(Course courses : student.getCourses()) {
			if(courses.getId() == courseId) {
				courses.setStudents(null);
			}
		}
		
	}

	

}
