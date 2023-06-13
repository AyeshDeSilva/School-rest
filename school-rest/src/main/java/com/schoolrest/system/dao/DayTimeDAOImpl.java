package com.schoolrest.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.schoolrest.system.entity.DayTime;

@Repository
public class DayTimeDAOImpl implements DayTimeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<DayTime> getTimes() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<DayTime> theQuery = currentSession.createQuery("from DayTime", DayTime.class);
		
		List<DayTime> time = theQuery.getResultList();
		
		return time;
	}

	@Override
	public void saveTime(DayTime theTime) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTime);
		
	}

	@Override
	public DayTime getTime(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		DayTime theDay = currentSession.get(DayTime.class, theId);
		
		return theDay;
	}

	@Override
	public void deleteTime(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from DayTime where id=:dayTimeId");
		
		theQuery.setParameter("dayTimeId", theId);
		
		theQuery.executeUpdate();
		
	}
	

}
