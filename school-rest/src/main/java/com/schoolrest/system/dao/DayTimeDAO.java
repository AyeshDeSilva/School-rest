package com.schoolrest.system.dao;

import java.util.List;

import com.schoolrest.system.entity.DayTime;


public interface DayTimeDAO {
	
	public List<DayTime> getTimes();
	
	public void saveTime(DayTime theTime);
	
	public DayTime getTime(int theId);
	
	public void deleteTime(int theId);


}
