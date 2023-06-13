package com.schoolrest.system.dao;

import java.util.List;

import com.schoolrest.system.entity.Course;

public interface CourseDAO {

	public List<Course> getCourses();

	public void saveCourse(Course saveCourse);

	public Course getCourse(int theId);

	public void deleteCourse(int theId);

	public Course addDay(int courseId, int dayId);

	public void removeDay(int courseId, int dayId);
	
}
