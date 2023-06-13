package com.schoolrest.system.entity;

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
@Table(name = "daytime")
public class DayTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "hh:mm")	
	@Column(name = "time_start")
	private Date startTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "hh:mm")	
	@Column(name = "time_end")
	private Date endTime;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(
			name = "day_daytime", 
			joinColumns = @JoinColumn(name = "day_time_id"), 
			inverseJoinColumns = @JoinColumn(name = "day_id"))
	@JsonIgnore
	private List<Day> days;
	 
	public DayTime() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDay(List<Day> day) {
		this.days = day;
	}


	
	

	
	
	
}
