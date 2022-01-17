package com.my.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.my.pojo.ProductInfo;

public class ProductInfoDynaSqlProvider {
	/**
	 * Create sql to get product information at current page
	 * @param params
	 * @return
	 */
	public String selectWithParam(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("product_info");
				if (params.get("productInfo") != null) {
					ProductInfo productInfo = (ProductInfo) params.get("productInfo");
					if (productInfo.getCode() != null && !"".equals(productInfo.getCode())) {
						WHERE(" code = #{productInfo.code} ");
					}
					if (productInfo.getName() != null && !productInfo.getName().equals("")) {
						WHERE("  name LIKE CONCAT ('%',#{productInfo.name},'%') ");
					}
					if (productInfo.getBrand() != null && !productInfo.getBrand().equals("")) {
						WHERE("  brand LIKE CONCAT ('%',#{productInfo.brand},'%') ");
					}
					if (productInfo.getType() != null && productInfo.getType().getId() > 0) {
						WHERE(" tid = #{productInfo.type.id} ");
					}
					if (productInfo.getPriceFrom() > 0) {
						WHERE(" price > #{productInfo.priceFrom} ");
					}
					if (productInfo.getPriceTo() > 0) {
						WHERE(" price <= #{productInfo.priceTo} ");
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
	 * Create sql to get total number of product by search pattern
	 * @param params
	 * @return
	 */
	public String count(final Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM("product_info");
				if (params.get("productInfo") != null) {
					ProductInfo productInfo = (ProductInfo) params.get("productInfo");
					if (productInfo.getCode() != null && !"".equals(productInfo.getCode())) {
						WHERE(" code = #{productInfo.code} ");
					}
					if (productInfo.getName() != null && !productInfo.getName().equals("")) {
						WHERE("  name LIKE CONCAT ('%',#{productInfo.name},'%') ");
					}
					if (productInfo.getBrand() != null && !productInfo.getBrand().equals("")) {
						WHERE("  brand LIKE CONCAT ('%',#{productInfo.brand},'%') ");
					}
					if (productInfo.getType() != null && productInfo.getType().getId() > 0) {
						WHERE(" tid = #{productInfo.type.id} ");
					}
					if (productInfo.getPriceFrom() > 0) {
						WHERE(" price > #{productInfo.priceFrom} ");
					}
					if (productInfo.getPriceTo() > 0) {
						WHERE(" price <= #{productInfo.priceTo} ");
					}
				}
			}
		}.toString();
	}
}
