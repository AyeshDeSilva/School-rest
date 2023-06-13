package com.schoolrest.system.service;

import java.util.List;

import com.schoolrest.system.entity.Day;

public interface DayService {

	public List<Day> getDays();

	public void saveDay(Day theDay);

	public Day getDay(int theId);

	public void deleteDay(int theId);

	public Day addTime(int dayId, int dayTimeId);

	public void removeTime(int dayId, int dayTimeId);

}
