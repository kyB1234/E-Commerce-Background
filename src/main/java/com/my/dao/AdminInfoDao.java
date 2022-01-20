package com.my.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.my.pojo.AdminInfo;

public interface AdminInfoDao {
	/**
	 * Get administrator by username and password
	 * 
	 * @param ai
	 * @return
	 */
	@Select("select * from admin_info where name = #{name} and pwd = #{pwd}")
	public AdminInfo selectByNameAndPwd(AdminInfo ai);

	/**
	 * Get administrator and relate function by id
	 * @param id
	 * @return
	 */
	@Select("select * from admin_info where id = #{id}")
	@Results({
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "name", property = "name"),
			@Result(column = "pwd", property = "pwd"),
			@Result(column = "id", property = "fs", many = @Many(select = "com.my.dao.FunctionDao.selectByAdminId", fetchType = FetchType.EAGER)) })
	public AdminInfo selectById(Integer id);

}
