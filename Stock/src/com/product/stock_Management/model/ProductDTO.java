package com.product.stock_Management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class ProductDTO {
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator ="auto")
	private int pid;
	private String pName;
	private String category;
	private String cName;
	private int quantity;
	private double price;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="order_History_Info", joinColumns=@JoinColumn(name="pid"), inverseJoinColumns =@JoinColumn(name="oid"))
	List<OrderInfoDTO> olist;
	
	public List<OrderInfoDTO> getOlist() {
		return olist;
	}
	public void setOlist(List<OrderInfoDTO> olist) {
		this.olist = olist;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
