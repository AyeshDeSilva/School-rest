package com.schoolrest.system.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolrest.system.entity.Course;
import com.schoolrest.system.exception.ResourseNotFoundException;
import com.schoolrest.system.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		
		Course theCourse = courseService.getCourse(courseId);
		
		if(theCourse == null) {
			throw new ResourseNotFoundException("Course id not found" + courseId);
		}
		
		return theCourse;
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse) {
		
		theCourse.setId(0);
		
		courseService.saveCourse(theCourse);
		
		return theCourse;
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course theCourse) {
		
		courseService.saveCourse(theCourse);
		
		return theCourse;
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable int courseId) {
		
		Course theCourse = courseService.getCourse(courseId);
		
		if(theCourse == null) {
			throw new ResourseNotFoundException("Course id not found" + courseId);
		}
		
		courseService.deleteCourse(courseId);
		
		return "Deleted Course id - " + courseId;
	}
	
	@PutMapping("/courses/{courseId}/days/{dayId}")
	public Course addDay(@PathVariable int courseId, @PathVariable int dayId) {
		
		courseService.addDay(courseId, dayId);
		
		return courseService.getCourse(courseId);
	}
	
	@DeleteMapping("/courses/{courseId}/days/{dayId}")
	public String removeDay(@PathVariable int courseId, @PathVariable int dayId) {
				
		courseService.getCourse(courseId);
		
		courseService.removeDay(courseId, dayId);
		
		return "Deleted Day id - " + dayId + " from Course id - " + courseId;
	}
	

}
