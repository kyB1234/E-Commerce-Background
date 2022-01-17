package com.my.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.my.pojo.UserInfo;

public class UserInfoDynaSqlProvider {
	
	/**
	 * Create sql to get user by search pattern
	 * @param params
	 * @return
	 */
	public String selectWithParam(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("user_info");
				if (params.get("userInfo") != null) {
					UserInfo userInfo = (UserInfo) params.get("userInfo");
					if (userInfo.getUserName() != null && !userInfo.getUserName().equals("")) {
						WHERE("  userName LIKE CONCAT ('%',#{userInfo.userName},'%') ");
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
	 * Create sql to get total number of user by search pattern
	 * @param params
	 * @return
	 */
	public String count(final Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM("user_info");
				if (params.get("userInfo") != null) {
					UserInfo userInfo = (UserInfo) params.get("userInfo");
					if (userInfo.getUserName() != null && !userInfo.getUserName().equals("")) {
						WHERE("  userName LIKE CONCAT ('%',#{userInfo.userName},'%') ");
					}
				}
			}
		}.toString();
	}
}
