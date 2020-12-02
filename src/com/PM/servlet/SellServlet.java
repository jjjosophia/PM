package com.PM.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.PM.dao.SellDao;
import com.PM.model.Sell;


@WebServlet("/SellServlet")
public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private SellDao sellDao;

	public SellServlet() {
		super();
	}

	public void init(){
		sellDao=new SellDao();		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setLocale(Locale.TAIWAN);
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setLocale(Locale.TAIWAN);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try { 
			switch(action){
			case "/sell/new":
				showNewForm(request,response);
				break;
			case "/sell/insert":
				insertSell(request,response);
				break;
			case "/sell/edit":
				showEditForm(request,response);
				break;
			case "/sell/update":
				updateSell(request,response);
				break;
			case "/sell/delete":
				deleteSell(request,response);
				break;
			default:
				listSell(request,response);
				break;
			}} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private void listSell(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		List < Sell > listSell = sellDao.selectAllSells();
		RequestDispatcher dispatcher;
		int totalrows = listSell.size();
		request.setAttribute("totalrows", totalrows);
		request.setAttribute("listSell", listSell);
		dispatcher = request.getRequestDispatcher("../backend/sell/list.jsp");		
		dispatcher.forward(request, response);
		System.out.println("listcheck");
	}	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("../backend/sell/form.jsp");		
		dispatcher.forward(request, response);		
	}
	private void insertSell(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	//int id= Integer.parseInt(request.getParameter("id"));
    	int shop_id= Integer.parseInt(request.getParameter("shop_id"));
		String shop_sell_id = request.getParameter("shop_sell_id");
		int products_id= Integer.parseInt(request.getParameter("products_id"));
		int products_price= Integer.parseInt(request.getParameter("products_price"));
		int sell_qty= Integer.parseInt(request.getParameter("sell_qty"));        
        String sell_status = request.getParameter("sell_status");
        String created_at = request.getParameter("created_at");       
        Sell newSell = new Sell(shop_id, shop_sell_id,products_id,products_price,sell_qty,sell_status, created_at);
        sellDao.insertSell(newSell);
        response.sendRedirect("list");
    }
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
        Sell existingSell = sellDao.selectSell(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/sell/form.jsp");
        request.setAttribute("sell", existingSell);
        dispatcher.forward(request, response);   
	}
	 private void updateSell(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
	        int id = Integer.parseInt(request.getParameter("id"));	        
	        int shop_id = Integer.parseInt(request.getParameter("shop_id"));	        
	        String shop_sell_id = request.getParameter("shop_sell_id");
	        int products_id = Integer.parseInt(request.getParameter("products_id"));	        
	        int products_price = Integer.parseInt(request.getParameter("products_price"));	        
	        int sell_qty = Integer.parseInt(request.getParameter("sell_qty"));
	        String sell_status = request.getParameter("sell_status");	       
	        String updated_at = request.getParameter("updated_at");
	        Sell updateSell = new Sell(id, shop_id, shop_sell_id, products_id,products_price,sell_qty,sell_status,updated_at);
	        sellDao.updateSell(updateSell);
	        response.sendRedirect("list");
	    }
	 private void deleteSell(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			sellDao.deleteSell(id);
			response.sendRedirect("list");		
		}
}
