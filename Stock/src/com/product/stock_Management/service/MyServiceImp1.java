package com.product.stock_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.stock_Management.doa.MyProDAO;
import com.product.stock_Management.model.ProductDTO;
@Component
public class MyServiceImp1 implements MyService{
     
	@Autowired
	MyProDAO mdao;
	

	@Override
	public List<ProductDTO> product() {
		return mdao.product();
	}
	
	@Override
	public boolean addProduct(ProductDTO pdto) {
		boolean b=mdao.addProduct(pdto);
		return b;
	}

	@Override
	public boolean modifyProduct(ProductDTO pdto) {
		mdao.modifyProduct(pdto);
		return true;
	}

	@Override
	public List<ProductDTO> search(String search) {
		List<ProductDTO> list=mdao.search(search);
		return list;
	}

	@Override
	public ProductDTO update(int id) {
		
		return mdao.update(id);
	}

	@Override
	public boolean updateproduct(ProductDTO dto) {
		boolean b=mdao.updateproduct(dto);
		return b;
	}

	@Override
	public ProductDTO addtocart(int id) {
		
		return mdao.addtocart(id);
	}

	@Override
	public ProductDTO add(ProductDTO dto) {
		
		return mdao.add(dto);
	}

	@Override
	public ProductDTO delete(int id) {
		
		return mdao.delete(id);
	}

	
      
}
