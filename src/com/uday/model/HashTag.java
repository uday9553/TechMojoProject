package com.uday.model;

public class HashTag implements Comparable<HashTag> {
	//to store the name
	String name;
	//this variable is used to store number of counts
	int count;
	public HashTag(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//comparing in reverse order
	@Override
	public int compareTo(HashTag o) {
		Integer count=getCount();
		Integer myCount=o.getCount();
		return myCount.compareTo(count);
	}

	
}
