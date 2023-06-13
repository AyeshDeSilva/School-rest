package com.schoolrest.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoolrest.system.entity.Day;
import com.schoolrest.system.entity.DayTime;

@Repository
public class DayDAOImpl implements DayDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Day> getDays() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Day> theQuery = currentSession.createQuery("from Day", Day.class);

		List<Day> student = theQuery.getResultList();

		return student;
	}

	@Override
	public void saveDay(Day theDay) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theDay);

	}

	@Override
	public Day getDay(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Day theDay = currentSession.get(Day.class, theId);

		return theDay;
	}

	@Override
	public void deleteDay(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Day where id=:dayId");

		theQuery.setParameter("dayId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public Day addTime(int dayId, int dayTimeId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Day day = currentSession.get(Day.class, dayId);

		DayTime dayTime = currentSession.get(DayTime.class, dayTimeId);

		day.addTime(dayTime);

		return day;
	}

	@Override
	public void removeTime(int dayId, int dayTimeId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Day day = currentSession.get(Day.class, dayId);

		for (DayTime dayTimes : day.getDayTimes()) {
			if (dayTimes.getId() == dayTimeId) {
				dayTimes.setDay(null);
			}
		}
	}

}
