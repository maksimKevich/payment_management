package com.bigasssolutions.pmc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", unique = true)
	private String name;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Event> eventList;

	public Category() {
	}

	public Category(long id, String name, List<Event> eventList) {
		this(id, name);
		this.eventList = eventList;
	}

	public Category(long id, String name) {
		this(name);
		this.id = id;
	}

	public Category(String name) {
		this.name = name;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
