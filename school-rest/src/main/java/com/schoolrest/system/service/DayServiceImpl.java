package com.schoolrest.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolrest.system.dao.DayDAO;
import com.schoolrest.system.entity.Day;

@Service
public class DayServiceImpl implements DayService {

	@Autowired
	private DayDAO dayDAO;
	
	@Override
	@Transactional
	public List<Day> getDays() {
		
		return dayDAO.getDays();
	}

	@Override
	@Transactional
	public void saveDay(Day theDay) {
		
		dayDAO.saveDay(theDay);	
	}

	@Override
	@Transactional
	public Day getDay(int theId) {
		
		return dayDAO.getDay(theId);
	}

	@Override
	@Transactional
	public void deleteDay(int theId) {
		
		dayDAO.deleteDay(theId);
		
	}

	@Override
	@Transactional
	public Day addTime(int dayId, int dayTimeId) {

		return dayDAO.addTime(dayId, dayTimeId);
	}

	@Override
	@Transactional
	public void removeTime(int dayId, int dayTimeId) {
		
		dayDAO.removeTime(dayId, dayTimeId);
	}


}
