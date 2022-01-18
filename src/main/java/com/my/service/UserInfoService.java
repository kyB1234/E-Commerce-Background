package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.pojo.Pager;
import com.my.pojo.UserInfo;

public interface UserInfoService {
	
	/**
	 * Get legal user
	 * @return
	 */
	public List<UserInfo> getValidUser();

	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	public UserInfo getUserInfoById(int id);

	/**
	 * Get user by page
	 * @param userInfo
	 * @param pager
	 * @return
	 */
	List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager);

	/**
	 * Get total number of user by search pattern
	 * @param params
	 * @return
	 */
	Integer count(Map<String, Object> params);
	
	/**
	 * Change status of user
	 * @param ids
	 * @param flag
	 */
	void modifyStatus(String ids, int flag); 
}
