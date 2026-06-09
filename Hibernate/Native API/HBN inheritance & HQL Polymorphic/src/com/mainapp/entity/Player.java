package com.mainapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
// @MappedSuperclassi // not create main player table and data of the other tables are stored perfectly
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //All data stored into one table
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)// Create all table, but main Player table is with null value
public class Player {
	
	@Id
	private int id;
	private String name;
	
	public Player() {
		
	}

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}
	
	
}
