package com.product.stock_Management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class OrderInfoDTO {
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator ="auto")
	
	private int oid;
	private double totalPrice;
	private double totalPriceWithGST;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="order_History_Info", joinColumns=@JoinColumn(name="oid"), inverseJoinColumns =@JoinColumn(name="pid"))
    List<ProductDTO> plist;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalPriceWithGST() {
		return totalPriceWithGST;
	}
	public void setTotalPriceWithGST(double totalPriceWithGST) {
		this.totalPriceWithGST = totalPriceWithGST;
	}
	public List<ProductDTO> getPlist() {
		return plist;
	}
	public void setPlist(List<ProductDTO> plist) {
		this.plist = plist;
	}
	

}
