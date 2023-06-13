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

import com.schoolrest.system.entity.DayTime;
import com.schoolrest.system.exception.ResourseNotFoundException;
import com.schoolrest.system.service.DayTimeService;

@RestController
@RequestMapping("/daytime")
public class DayTimeRestController {

	@Autowired
	private DayTimeService dayTimeService;

	@GetMapping("/daytimes")
	public List<DayTime> getTimes() {

		return dayTimeService.getTimes();
	}

	@GetMapping("/daytimes/{dayTimeId}")
	public DayTime getTime(@PathVariable int dayTimeId) {

		DayTime theTime = dayTimeService.getTime(dayTimeId);

		if (theTime == null) {
			throw new ResourseNotFoundException("Daytime id not found " + dayTimeId);
		}

		return theTime;
	}

	@PostMapping("/daytimes")
	public DayTime addTime(@RequestBody DayTime theDayTime) {

		theDayTime.setId(0);

		dayTimeService.saveTime(theDayTime);

		return theDayTime;
	}

	@PutMapping("/daytimes")
	public DayTime updateDay(@RequestBody DayTime theDay) {

		dayTimeService.saveTime(theDay);

		return theDay;
	}

	@DeleteMapping("/daytimes/{dayTimeId}")
	public String deleteDay(@PathVariable int dayTimeId) {

		DayTime theTime = dayTimeService.getTime(dayTimeId);

		if (theTime == null) {
			throw new ResourseNotFoundException("Daytime id not found " + dayTimeId);
		}

		dayTimeService.deleteTime(dayTimeId);

		return "Deleted Time id - " + dayTimeId;
	}

}
