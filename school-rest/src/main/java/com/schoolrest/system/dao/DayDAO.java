package com.schoolrest.system.dao;

import java.util.List;

import com.schoolrest.system.entity.Day;


public interface DayDAO {
	
	public List<Day> getDays();
	
	public void saveDay(Day theDay);
	
	public Day getDay(int theId);
	
	public void deleteDay(int theId);
	
	public Day addTime(int dayId, int dayTimeId);
	
	public void removeTime(int dayId, int dayTimeId); 


}
