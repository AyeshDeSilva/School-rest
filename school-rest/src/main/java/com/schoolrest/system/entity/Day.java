package com.schoolrest.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="day")
public class Day {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;

	@Column(name = "start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")	
	private Date startDate;
	
	@Column(name = "end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")	
	private Date endDate;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(
			name = "day_daytime", 
			joinColumns = @JoinColumn(name = "day_id"), 
			inverseJoinColumns = @JoinColumn(name = "day_time_id")
			)
	private List<DayTime> dayTimes;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(
			name = "course_day", 
			joinColumns = @JoinColumn(name = "day_id"), 
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	@JsonIgnore
	private List<Course> courses;
	
	public Day() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public List<DayTime> getDayTimes() {
		return dayTimes;
	}


	public void setDayTimes(List<DayTime> dayTimes) {
		this.dayTimes = dayTimes;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	public void addTime(DayTime time) {
		
		if(dayTimes == null) {
			dayTimes = new ArrayList<>();
		}
		
		dayTimes.add(time);
	}
	
	
	
	
	
	
}
