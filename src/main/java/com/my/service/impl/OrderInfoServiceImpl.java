package com.my.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.OrderInfoDao;
import com.my.pojo.OrderDetail;
import com.my.pojo.OrderInfo;
import com.my.pojo.Pager;
import com.my.service.OrderInfoService;

@Service("orderInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	OrderInfoDao orderInfoDao;

	public List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderInfo", orderInfo);
		int recordCount = orderInfoDao.count(params);
		pager.setRowCount(recordCount);
		if (recordCount > 0) {
			params.put("pager", pager);
		}
		return orderInfoDao.selectByPage(params);
	}

	public Integer count(Map<String, Object> params) {
		return orderInfoDao.count(params);
	}

	public int addOrderInfo(OrderInfo oi) {
		return orderInfoDao.saveOrderInfo(oi);
	}

	public int addOrderDetail(OrderDetail od) {
		return orderInfoDao.saveOrderDetail(od);
	}

	public OrderInfo getOrderInfoById(int id) {
		return orderInfoDao.getOrderInfoById(id);
	}

	public List<OrderDetail> getOrderDetailByOid(int oid) {
		return orderInfoDao.getOrderDetailByOid(oid);
	}

	public int deleteOrder(int id) {
		int result = 1;
		try {
			orderInfoDao.deleteOrderDetail(id);
			orderInfoDao.deleteOrderInfo(id);
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}
}
