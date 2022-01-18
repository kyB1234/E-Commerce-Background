package com.my.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.UserInfoDao;
import com.my.pojo.Pager;
import com.my.pojo.UserInfo;
import com.my.service.UserInfoService;

@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao userInfoDao;

	public List<UserInfo> getValidUser() {
		return userInfoDao.getValidUser();
	}

	public UserInfo getUserInfoById(int id) {
		return userInfoDao.getUserInfoById(id);
	}

	public List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userInfo", userInfo);
		int recordCount = userInfoDao.count(params);
		pager.setRowCount(recordCount);
		if (recordCount > 0) {
			params.put("pager", pager);
		}
		return userInfoDao.selectByPage(params);
	}

	public Integer count(Map<String, Object> params) {
		return userInfoDao.count(params);
	}

	public void modifyStatus(String ids, int flag) {
		userInfoDao.updateState(ids, flag);

	}

}
