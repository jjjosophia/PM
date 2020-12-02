package com.PM.model;

public class Product {
	protected String picture;
	protected int products_id ;
    protected String products_name;    
    protected int stock;    
    protected String created_at;
    protected String updated_at;	
	public Product(String picture, int products_id, String products_name, int stock, String created_at,
			String updated_at) {
		super();
		this.picture = picture;
		this.products_id = products_id;
		this.products_name = products_name;
		this.stock = stock;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public int getProducts_id() {
		return products_id;
	}
	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}
	public String getProducts_name() {
		return products_name;
	}
	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
    
    
}
