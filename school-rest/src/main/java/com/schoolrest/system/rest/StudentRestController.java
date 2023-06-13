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

import com.schoolrest.system.entity.Student;
import com.schoolrest.system.exception.ResourseNotFoundException;
import com.schoolrest.system.service.CourseService;
import com.schoolrest.system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		Student theStudent = studentService.getStudent(studentId);
		
		if (theStudent == null) {

			throw new ResourseNotFoundException("Student id not found " + studentId);

		}

		return theStudent;
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {

		theStudent.setId(0);

		studentService.saveStudent(theStudent);

		return theStudent;
	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent) {

		studentService.saveStudent(theStudent);

		return theStudent;
	}

	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {

		Student theStudent = studentService.getStudent(studentId);

		if (theStudent == null) {
			throw new ResourseNotFoundException("Student id not found " + studentId);
		}

		studentService.deleteStudent(studentId);

		return "Deleted student id - " + studentId;
	}

	@PutMapping("/students/{studentId}/courses/{courseId}")
	public Student addCourse(@PathVariable int studentId, @PathVariable int courseId) {
					
//		Student student = studentService.getStudent(studentId);
		
		
//		for(Day day : )) {
//			
//			if(day == ) {
//				
//				if(day.getDayTimes() == ) {
//					throw new StudentCourseRestException();
//				}
//				
//			}
//			
//		}
		
		studentService.addCourse(studentId, courseId);

		return studentService.getStudent(studentId);
	}

	@DeleteMapping("/students/{studentId}/courses/{courseId}")
	public String removeCourse(@PathVariable int studentId, @PathVariable int courseId) {

		studentService.getStudent(studentId);

		studentService.removeCourse(studentId, courseId);

		return "Deleted course id - " + courseId + " from student id - " + studentId;
	}

}
