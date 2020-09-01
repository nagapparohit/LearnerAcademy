package com.nagappa.model;

public class Standard {

	private int value; 
	private char section;
	
	public Standard() {
		super();
	}
	public Standard(int value, char section) {
		super();
		this.value = value;
		this.section = section;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Standard [value=" + value + ", section=" + section + "]";
	}
	
	
	
}
