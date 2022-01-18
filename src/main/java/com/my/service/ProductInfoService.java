package com.my.service;

import java.util.List;
import java.util.Map;

import com.my.pojo.Pager;
import com.my.pojo.ProductInfo;

public interface ProductInfoService {
	/**
	 * Get production information by page
	 * @param productInfo
	 * @param pager
	 * @return
	 */
	List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager);

	/**
	 * Get the total number of roduct by serch pattern
	 * @param params
	 * @return
	 */
	Integer count(Map<String, Object> params);

	/**
	 * Add a new product information
	 * @param pi
	 */
	public void addProductInfo(ProductInfo pi);
	
	/**
	 * Update product information
	 * @param pi
	 */
	public void modifyProductInfo(ProductInfo pi);
	
	/**
	 * Change the status of product
	 * @param ids
	 * @param flag
	 */
	void modifyStatus(String ids, int flag);

	/**
	 * Get all on sale product(statues = 1)
	 * @return
	 */
	List<ProductInfo> getOnSaleProduct(); 
	
	/**
	 * Get product by id
	 * @param id
	 * @return
	 */
	ProductInfo getProductInfoById(int id);
}
