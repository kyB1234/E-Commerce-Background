package com.my.pojo;

import java.util.HashSet;
import java.util.Set;

public class Functions implements Comparable<Functions>{
	private int id;
	private String name;
	private int parentid;
	private boolean isleaf;
	// Associated properties
	private Set<AdminInfo> ais = new HashSet<AdminInfo>();
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
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public boolean isIsleaf() {
		return isleaf;
	}
	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}
	public Set<AdminInfo> getAis() {
		return ais;
	}
	public void setAis(Set<AdminInfo> ais) {
		this.ais = ais;
	}
	public int compareTo(Functions arg0) {
		return ((Integer) this.getId()).compareTo((Integer) (arg0.getId()));
	}
	
}
