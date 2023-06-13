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

import com.schoolrest.system.entity.Day;
import com.schoolrest.system.exception.ResourseNotFoundException;
import com.schoolrest.system.service.DayService;

@RestController
@RequestMapping("/day")
public class DayRestController {

	@Autowired
	private DayService dayService;

	@GetMapping("/days")
	public List<Day> getDays() {

		return dayService.getDays();
	}

	@GetMapping("/days/{dayId}")
	public Day getDay(@PathVariable int dayId) {

		Day theDay = dayService.getDay(dayId);

		if (theDay == null) {
			throw new ResourseNotFoundException("Day id not found " + dayId);
		}

		return theDay;
	}

	@PostMapping("/days")
	public Day addDay(@RequestBody Day theDay) {

		theDay.setId(0);

		dayService.saveDay(theDay);

		return theDay;
	}

	@PutMapping("/days")
	public Day updateDay(@RequestBody Day theDay) {

		dayService.saveDay(theDay);

		return theDay;
	}

	@DeleteMapping("/days/{dayId}")
	public String deleteDay(@PathVariable int dayId) {

		Day theDay = dayService.getDay(dayId);

		if (theDay == null) {
			throw new ResourseNotFoundException("Day id not found " + dayId);
		}

		dayService.deleteDay(dayId);

		return "Deleted Course id - " + dayId;
	}

	@PutMapping("/days/{dayId}/daytimes/{dayTimeId}")
	public Day addTime(@PathVariable int dayId, @PathVariable int dayTimeId) {

		dayService.addTime(dayId, dayTimeId);

		return dayService.getDay(dayId);
	}

	@DeleteMapping("/days/{dayId}/daytimes/{dayTimeId}")
	public String removeTime(@PathVariable int dayId, @PathVariable int dayTimeId) {

		Day theDay = dayService.getDay(dayId);


		dayService.removeTime(dayId, dayTimeId);

		return "Deleted Time id - " + dayTimeId + " from Day id - " + dayId;
	}

}
