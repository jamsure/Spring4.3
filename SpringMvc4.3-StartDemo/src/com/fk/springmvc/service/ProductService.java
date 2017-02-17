package com.fk.springmvc.service;

import com.fk.springmvc.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
