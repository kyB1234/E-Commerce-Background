package com.my.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.my.dao.provider.OrderInfoDynaSqlProvider;
import com.my.pojo.OrderDetail;
import com.my.pojo.OrderInfo;

public interface OrderInfoDao {
	/**
	 * Get order information at current page
	 * @param params
	 * @return
	 */
	@Results({
		@Result(column = "uid", property = "ui", one = @One(select = "com.ecpbm.dao.UserInfoDao.getUserInfoById", fetchType = FetchType.EAGER)) })
	@SelectProvider(type = OrderInfoDynaSqlProvider.class, method = "selectWithParam")
	List<OrderInfo> selectByPage(Map<String, Object> params);
	
	/**
	 * Get total number of order by search pattern
	 * @param params
	 * @return
	 */
	@SelectProvider(type = OrderInfoDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
	
	/**
	 * Save order information
	 * @param oi
	 * @return
	 */
	@Insert("insert into order_info(uid,status,ordertime,orderprice) "+
	"values(#{uid},#{status},#{ordertime},#{orderprice})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int saveOrderInfo(OrderInfo oi);
	
	/**
	 * Save order detail
	 * @param od
	 * @return
	 */
	@Insert("insert into order_detail(oid,pid,num) values(#{oid},#{pid},#{num})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int saveOrderDetail(OrderDetail od);
	
	/**
	 * Get order information by id
	 * @param id
	 * @return
	 */
	@Results({
		@Result(column = "uid", property = "ui", one = @One(select = "com.ecpbm.dao.UserInfoDao.getUserInfoById", fetchType = FetchType.EAGER)) })
	@Select("select * from order_info where id = #{id}")
	public OrderInfo getOrderInfoById(int id);
	
	/**
	 * get order detail by id
	 * @param oid
	 * @return
	 */
	@Results({
		@Result(column = "pid", property = "pi", one = @One(select = "com.ecpbm.dao.ProductInfoDao.getProductInfoById", fetchType = FetchType.EAGER)) })
	@Select("select * from order_detail where oid = #{oid}")
	public List<OrderDetail> getOrderDetailByOid(int oid);
	
	/**
	 * Delete order information
	 * @param id
	 * @return
	 */
	@Delete("delete from order_info where id=#{id}")
	public int deleteOrderInfo(int id);
	
	/**
	 * Delete order detail
	 * @param id
	 * @return
	 */
	@Delete("delete from order_detail where oid=#{id}")
	public int deleteOrderDetail(int id);
}
