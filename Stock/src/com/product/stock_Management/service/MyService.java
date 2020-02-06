package com.product.stock_Management.service;

import java.util.List;

import com.product.stock_Management.model.ProductDTO;

public interface MyService {
	
	public List<ProductDTO> product();
	public boolean addProduct(ProductDTO pdto);
	public boolean modifyProduct(ProductDTO pdto);
	public List<ProductDTO> search(String search);
	public ProductDTO update(int id);
	public boolean updateproduct(ProductDTO dto);
	public ProductDTO addtocart(int id);
	public ProductDTO add(ProductDTO dto);
	public ProductDTO delete(int id);

}
