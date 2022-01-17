package com.my.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.my.pojo.OrderInfo;

public class OrderInfoDynaSqlProvider {
	/**
	 * Creater sql to get order information at current page
	 * @param params
	 * @return
	 */
	public String selectWithParam(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("order_info");
				if (params.get("orderInfo") != null) {
					OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
					if (orderInfo.getId() != null && orderInfo.getId() > 0) {
						WHERE(" id = #{orderInfo.id} ");
					} else {
						if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
							WHERE(" status = #{orderInfo.status} ");
						}
						if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())) {
							WHERE(" ordertime >= #{orderInfo.orderTimeFrom} ");
						}
						if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())) {
							WHERE(" ordertime < #{orderInfo.orderTimeTo} ");
						}
						if (orderInfo.getUid() > 0) {
							WHERE(" uid = #{orderInfo.uid} ");
						}
					}
				}
			}
		}.toString();
		if (params.get("pager") != null) {
			sql += " limit #{pager.firstLimitParam} , #{pager.perPageRows}  ";
		}
		return sql;
	}

	/**
	 * Creater sql to get total number of order by search pattern
	 * @param params
	 * @return
	 */
	public String count(final Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM("order_info");
				if (params.get("orderInfo") != null) {
					OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
					if (orderInfo.getId() != null && orderInfo.getId() > 0) {
						WHERE(" id = #{orderInfo.id} ");
					} else {
						if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
							WHERE(" status = #{orderInfo.status} ");
						}
						if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())) {
							WHERE(" ordertime >= #{orderInfo.orderTimeFrom} ");
						}
						if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())) {
							WHERE(" ordertime < #{orderInfo.orderTimeTo} ");
						}
						if (orderInfo.getUid() > 0) {
							WHERE(" uid = #{orderInfo.uid} ");
						}
					}
				}
			}
		}.toString();
	}
}
