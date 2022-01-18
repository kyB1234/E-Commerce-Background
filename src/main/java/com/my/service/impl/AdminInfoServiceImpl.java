package com.my.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.AdminInfoDao;
import com.my.pojo.AdminInfo;
import com.my.service.AdminInfoService;

@Service("adminInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AdminInfoServiceImpl implements AdminInfoService {

	@Autowired
	private AdminInfoDao adminInfoDao;

	public AdminInfo login(AdminInfo ai) {
		return adminInfoDao.selectByNameAndPwd(ai);
	}

	public AdminInfo getAdminInfoAndFunctions(Integer id) {
		return adminInfoDao.selectById(id);
	}

}
