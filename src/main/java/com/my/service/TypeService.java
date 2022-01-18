package com.my.service;

import java.util.List;

import com.my.pojo.Type;

public interface TypeService {
	/**
	 * Get all type
	 * @return
	 */
	public List<Type> getAll();
	
	/**
	 * Add a new type
	 * @param type
	 * @return
	 */
	public int addType(Type type); 
	
	/**
	 * Update type
	 * @param type
	 */
	public void updateType(Type type);
}
