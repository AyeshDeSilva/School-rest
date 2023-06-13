package com.schoolrest.system.service;

import java.util.List;

import com.schoolrest.system.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public void saveCourse(Course theCourse);
	
	public Course getCourse(int theId);
	
	public void deleteCourse(int theId);
	
	public Course addDay(int courseId, int dayId);

	public void removeDay(int courseId, int dayId);
	
}
