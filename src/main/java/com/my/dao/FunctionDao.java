package com.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.my.pojo.Functions;

public interface FunctionDao {
	/**
	 * Get all functions by administrator id
	 * @param aid
	 * @return
	 */
	@Select("select * from functions where id in (select fid from powers where aid = #{aid} )")
	public List<Functions> selectByAdminId(Integer aid);
}
