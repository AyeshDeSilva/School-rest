package com.schoolrest.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolrest.system.dao.DayTimeDAO;
import com.schoolrest.system.entity.DayTime;

@Service
public class DayTimeServiceImpl implements DayTimeService {

	@Autowired
	private DayTimeDAO dayTimeDAO;
	
	@Override
	@Transactional
	public List<DayTime> getTimes() {
		
		return dayTimeDAO.getTimes();
	}

	@Override
	@Transactional
	public void saveTime(DayTime theDay) {
		
		dayTimeDAO.saveTime(theDay);	
	}

	@Override
	@Transactional
	public DayTime getTime(int theId) {
		
		return dayTimeDAO.getTime(theId);
	}

	@Override
	@Transactional
	public void deleteTime(int theId) {
		
		dayTimeDAO.deleteTime(theId);
		
	}


}
