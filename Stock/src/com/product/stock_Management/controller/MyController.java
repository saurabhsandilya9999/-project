package com.product.stock_Management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.product.stock_Management.model.OrderInfoDTO;
import com.product.stock_Management.model.ProductDTO;
import com.product.stock_Management.service.MyService;
@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/addpro")
	public String addpro() {
		return "addproduct";
	}
	
	@RequestMapping(value="/addproduct",method =RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute ProductDTO pdto) {
		boolean b=ms.addProduct(pdto);
		if(b) {
			return new ModelAndView("success","success","Product successfully added");
			}else {
			return new ModelAndView("success","failed","product not added try again");
		}
	}
	
	@RequestMapping("/modyproduct")
	public ModelAndView modifyProduct() {
		List<ProductDTO> list=ms.product();
		return new ModelAndView("modify","list",list);
	}
	@RequestMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam int id) {
		ProductDTO dto=ms.addtocart(id);
		return new ModelAndView("addtocart","dto",dto);
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView search(@RequestParam String search) {
		List<ProductDTO> list=ms.search(search);
		return new ModelAndView("search","list",list);
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam int id) {
		ProductDTO dto=ms.update(id);
		return new ModelAndView("updateproduct","dto",dto);
	}
	
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public ModelAndView updateproduct(@ModelAttribute ProductDTO dto) {
		boolean b=ms.updateproduct(dto);
		if(b) {
			return new ModelAndView("success","success","updated successfully");
		}else {
			return new ModelAndView("success","failed","not updated");
		}
	}
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute ProductDTO dto) {
		ProductDTO pdto=ms.add(dto);
		if(pdto!=null) {
			return new ModelAndView("cart","dto",pdto);
		}else {
			return new ModelAndView("success","failed","out of stock or limited stock");
		}
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		List<ProductDTO> list=ms.product();
		return new ModelAndView("home","list",list);
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		ProductDTO dto=ms.delete(id);
		if(dto==null) {
			List<ProductDTO> list=ms.product();
			return new ModelAndView("home","list",list);
		}else {
			List<ProductDTO> list=ms.product();
			return new ModelAndView("home","list",list);
		}
	}

}
