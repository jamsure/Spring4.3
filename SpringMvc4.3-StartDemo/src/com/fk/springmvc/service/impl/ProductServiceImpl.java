package com.fk.springmvc.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.fk.springmvc.domain.Product;
import com.fk.springmvc.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	private Map<Long, Product> products =new HashMap<Long,Product>();  //数据库的数据保存与获取
	private AtomicLong generator =new AtomicLong();
	
	public ProductServiceImpl() {
		Product product=new Product();
		product.setName("MiBook");
		product.setDescription("小米笔记本天下无敌！");
		product.setPrice(4999.0d);
		add(product);
		
	}
	
	@Override
	public Product add(Product product) {
		long newid=generator.incrementAndGet();
		product.setId(newid);
		
		//保存到MAP中，此步模拟数据保存到数据库
		products.put(newid, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);

	}

}
