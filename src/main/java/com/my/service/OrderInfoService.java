package com.my.service;

import java.util.List;
import java.util.Map;
import com.my.pojo.*;

public interface OrderInfoService {
	/**
	 * Get order information by page
	 * @param orderInfo
	 * @param pager
	 * @return
	 */
	List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager);

	/**
	 * Get total number of order by search pattern
	 * @param params
	 * @return
	 */
	Integer count(Map<String, Object> params);

	/**
	 * Add a new order information
	 * @param oi
	 * @return
	 */
	public int addOrderInfo(OrderInfo oi);

	/**
	 * Add a new order detail
	 * @param od
	 * @return
	 */
	public int addOrderDetail(OrderDetail od);

	/**
	 * Get order information by id
	 * @param id
	 * @return
	 */
	public OrderInfo getOrderInfoById(int id);

	/**
	 * Get order detail by id
	 * @param oid
	 * @return
	 */
	public List<OrderDetail> getOrderDetailByOid(int oid);

	/**
	 * Delete a order
	 * @param id
	 * @return
	 */
	public int deleteOrder(int id);
}
