package com.schoolrest.system.service;

import java.util.List;

import com.schoolrest.system.entity.DayTime;


public interface DayTimeService {
	
	public List<DayTime> getTimes();
	
	public void saveTime(DayTime theDay);
	
	public DayTime getTime(int theId);
	
	public void deleteTime(int theId);
	
}
