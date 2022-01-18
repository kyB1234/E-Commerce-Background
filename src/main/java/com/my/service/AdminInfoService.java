package com.my.service;

import com.my.pojo.AdminInfo;

public interface AdminInfoService {
	/**
	 * Login authentication
	 * @param ai
	 * @return
	 */
	public AdminInfo login(AdminInfo ai);
	
	/**
	 * Get administrator and functions by id
	 * @param id
	 * @return
	 */
	public AdminInfo getAdminInfoAndFunctions(Integer id);
}
