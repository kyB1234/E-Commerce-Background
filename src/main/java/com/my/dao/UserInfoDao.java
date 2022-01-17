package com.my.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.my.dao.provider.UserInfoDynaSqlProvider;
import com.my.pojo.UserInfo;

public interface UserInfoDao {
	/**
	 * Get all legal user (status = 1)
	 * @return
	 */
	@Select("select * from user_info where status = 1")
	public List<UserInfo> getValidUser();
	
	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	@Select("select * from user_info where id = #{id}")
	public UserInfo getUserInfoById(int id);
	
	/**
	 * Get user by search pattern
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserInfoDynaSqlProvider.class, method = "selectWithParam")
	List<UserInfo> selectByPage(Map<String, Object> params);
	
	/**
	 * Get total number of user by search pattern
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserInfoDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
	
	/**
	 * Update user status
	 * @param ids
	 * @param flag
	 */
	@Update("update user_info set status=#{flag} where id in (${ids})")
	void updateState(@Param("ids") String ids, @Param("flag") int flag);

}
