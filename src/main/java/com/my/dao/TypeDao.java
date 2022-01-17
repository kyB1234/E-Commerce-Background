package com.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.pojo.Type;

public interface TypeDao {
	/**
	 * Get all product type
	 * @return
	 */
	@Select("select * from type")
	public List<Type> selectAll();
	
	/**
	 * Get product by id
	 * @param id
	 * @return
	 */
	@Select("select * from type where id = #{id}")
	public Type selectById(int id);
	
	/**
	 * Insert a new type
	 * @param type
	 * @return
	 */
	@Insert("insert into type(name) values(#{name})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int add(Type type);
	
	/**
	 * Update type name by id
	 * @param type
	 * @return
	 */
	@Update("update type set name = #{name} where  id = #{id}")
	public int update(Type type);
}
