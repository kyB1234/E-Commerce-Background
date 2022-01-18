package com.my.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.ProductInfoDao;
import com.my.pojo.Pager;
import com.my.pojo.ProductInfo;
import com.my.service.ProductInfoService;

@Service("productInfoService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	ProductInfoDao productInfoDao;

	public List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productInfo", productInfo);
		int recordCount = productInfoDao.count(params);
		pager.setRowCount(recordCount);
		if (recordCount > 0) {
			params.put("pager", pager);
		}
		return productInfoDao.selectByPage(params);
	}

	public Integer count(Map<String, Object> params) {
		return productInfoDao.count(params);
	}

	public void addProductInfo(ProductInfo pi) {
		productInfoDao.save(pi);
	}

	public void modifyProductInfo(ProductInfo pi) {
		productInfoDao.edit(pi);
	}

	public void modifyStatus(String ids, int flag) {
		productInfoDao.updateState(ids, flag);
	}

	public List<ProductInfo> getOnSaleProduct() {
		return productInfoDao.getOnSaleProduct();
	}

	public ProductInfo getProductInfoById(int id) {
		return productInfoDao.getProductInfoById(id);
	}
}
