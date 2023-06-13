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

import com.schoolrest.system.entity.Instructor;
import com.schoolrest.system.exception.ResourseNotFoundException;
import com.schoolrest.system.service.InstructorService;


@RestController
@RequestMapping("/instructor")
public class InstructorRestController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/instructors")
	public List<Instructor> getInstructors(){
		return instructorService.getInstructors();
	}
	
	@GetMapping("/instructors/{instructorId}")
	public Instructor getStudent(@PathVariable int instructorId) {
		
		Instructor theInstructor = instructorService.getInstructor(instructorId);
		
		if(theInstructor == null) {
			throw new ResourseNotFoundException("Instuctor id not found " + instructorId);
		}
		
		return theInstructor;
	}
	
	@PostMapping("/instructors")
	public Instructor addInstructor(@RequestBody Instructor theInstructor) {
		
		theInstructor.setId(0);
		
		instructorService.saveInstructors(theInstructor);
		
		return theInstructor;
	}
	
	@PutMapping("/instructors")
	public Instructor updateInstructor(@RequestBody Instructor theInstructor) {
		
		instructorService.saveInstructors(theInstructor);
		
		return theInstructor;
	}
	
	@DeleteMapping("/instructors/{instructorId}")
	public String deleteInstructor(@PathVariable int instructorId) {
		
		Instructor theInstructor = instructorService.getInstructor(instructorId);
		
		if(theInstructor == null) {
			throw new ResourseNotFoundException("Intsructor id not found " + instructorId);
		}
		
		instructorService.deleteInstructor(instructorId);
		
		return "Deleted Instructor id - " + instructorId;
	}
	
	@PutMapping("/instructors/{instructorId}/courses/{courseId}")
	public Instructor addInstructor(@PathVariable int instructorId, @PathVariable int courseId) {
		
		instructorService.addCourse(instructorId, courseId);
		
		return instructorService.getInstructor(instructorId);
		
	}
	
	@DeleteMapping("/instructors/{instructorId}/courses/{courseId}")
	public String removeInstructor(@PathVariable int instructorId, @PathVariable int courseId) {
				
		instructorService.getInstructor(instructorId);
		
		instructorService.removeCourse(instructorId, courseId);
		
		return "Deleted Course id - " + courseId + " from Instructor id - " + instructorId;
	}
	

}
