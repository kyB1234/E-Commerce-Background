package com.my.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.my.dao.provider.ProductInfoDynaSqlProvider;
import com.my.pojo.ProductInfo;

public interface ProductInfoDao {
	/**
	 * Get product information at current page
	 * @param params
	 * @return
	 */
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "code", property = "code"),
		@Result(column = "name", property = "name"), 
		@Result(column = "brand", property = "brand"),
		@Result(column = "pic", property = "pic"), 
		@Result(column = "num", property = "num"),
		@Result(column = "price", property = "price"), 
		@Result(column = "intro", property = "intro"),
		@Result(column = "status", property = "status"),
		@Result(column = "tid", property = "type", one = @One(select = "com.ecpbm.dao.TypeDao.selectById", fetchType = FetchType.EAGER)) })
	@SelectProvider(type = ProductInfoDynaSqlProvider.class, method = "selectWithParam")
	public List<ProductInfo> selectByPage(Map<String, Object> params);
	
	/**
	 *  Get total number of product by search pattern
	 * @param params
	 * @return
	 */
	@SelectProvider(type = ProductInfoDynaSqlProvider.class, method = "count")
	public Integer count(Map<String, Object> params);

	/**
	 * Insert product
	 * @param pi
	 */
	@Insert("insert into product_info(code,name,tid,brand,pic,num,price,intro,status) " +
	"values(#{code},#{name},#{type.id},#{brand},#{pic},#{num},#{price},#{intro},#{status})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void save(ProductInfo pi);
	
	/**
	 * Update product
	 * @param pi
	 */
	@Update("update product_info set code=#{code},name=#{name},tid=#{type.id}," +
	"brand=#{brand},pic=#{pic},num=#{num},price=#{price},intro=#{intro},status=#{status} where id=#{id}")
	void edit(ProductInfo pi);
	
	/**
	 * Uodate status of prodect
	 * @param ids
	 * @param flag
	 */
	@Update("update product_info set status=#{flag} where id in (${ids})")
	void updateState(@Param("ids") String ids, @Param("flag") int flag);
	
	/**
	 * Get all in selling goods
	 * @return
	 */
	@Select("select * from product_info where status=1")
	List<ProductInfo> getOnSaleProduct();
	
	/**
	 * Get product by id
	 * @param id
	 * @return
	 */
	@Select("select * from product_info where id=#{id}")
	ProductInfo getProductInfoById(int id);
}
