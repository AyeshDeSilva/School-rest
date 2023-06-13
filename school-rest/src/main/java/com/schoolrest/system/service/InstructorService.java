package com.schoolrest.system.service;

import java.util.List;

import com.schoolrest.system.entity.Instructor;


public interface InstructorService {

	public List<Instructor> getInstructors();

	public void saveInstructors(Instructor theInstructor);

	public Instructor getInstructor(int theId);

	public void deleteInstructor(int theId);

	public Instructor addCourse(int instructorId, int courseId);

	public void removeCourse(int instructorId, int courseId);

}
