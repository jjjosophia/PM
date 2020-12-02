package com.PM.model;

public class Sell {
	protected int id;
	protected int shop_id ;
    protected String shop_sell_id;    
    protected int products_id;    
    protected int products_price;
    protected int sell_qty;	
    protected String sell_status;	
    protected String created_at;	
    protected String updated_at;
	
	


	public Sell(int id, int shop_id, String shop_sell_id, int products_id, int products_price, int sell_qty,
			String sell_status, String created_at, String updated_at) {
		super();
		this.id = id;
		this.shop_id = shop_id;
		this.shop_sell_id = shop_sell_id;
		this.products_id = products_id;
		this.products_price = products_price;
		this.sell_qty = sell_qty;
		this.sell_status = sell_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Sell(int shop_id, String shop_sell_id, int products_id, int products_price, int sell_qty, String sell_status,
			String created_at) {
		super();
		this.shop_id = shop_id;
		this.shop_sell_id = shop_sell_id;
		this.products_id = products_id;
		this.products_price = products_price;
		this.sell_qty = sell_qty;
		this.sell_status = sell_status;
		this.created_at = created_at;		
	}
	public Sell(int id, int shop_id, String shop_sell_id, int products_id, int products_price, int sell_qty,
			String sell_status, String updated_at) {
		super();
		this.id = id;
		this.shop_id = shop_id;
		this.shop_sell_id = shop_sell_id;
		this.products_id = products_id;
		this.products_price = products_price;
		this.sell_qty = sell_qty;
		this.sell_status = sell_status;
		this.updated_at = updated_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_sell_id() {
		return shop_sell_id;
	}

	public void setShop_sell_id(String shop_sell_id) {
		this.shop_sell_id = shop_sell_id;
	}

	public int getProducts_id() {
		return products_id;
	}

	public void setProducts_id(int products_id) {
		this.products_id = products_id;
	}

	public int getProducts_price() {
		return products_price;
	}

	public void setProducts_price(int products_price) {
		this.products_price = products_price;
	}

	public int getSell_qty() {
		return sell_qty;
	}

	public void setSell_qty(int sell_qty) {
		this.sell_qty = sell_qty;
	}

	public String getSell_status() {
		return sell_status;
	}

	public void setSell_status(String sell_status) {
		this.sell_status = sell_status;
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
