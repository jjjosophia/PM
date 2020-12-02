package com.PM.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PM.dao.ProductDao;
import com.PM.model.Product;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/ProductsServlet")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private String uploadPath;
	private SmartUpload smart;
    
    public ProductServlet() {
        super();       
    }
    public void init(){
    	productDao=new ProductDao();
		uploadPath = getServletContext().getRealPath("/")+"upload";
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
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
		try{
            switch(action){
                case "/product/new":
                    showNewForm(request, response);
                    break;
                case "/product/insert":
                    insertProduct(request, response);
                    break;
                case "/product/delete":
                    deleteProduct(request, response);
                    break;
                case "/product/edit":
                    showEditForm(request, response);
                    break;
                case "/product/update":
                    updateProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }		
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, NumberFormatException, ServletException {
		String filename = "";
		String picture = "";
		try {
			smart = new SmartUpload();
			smart.initialize(getServletConfig(), request, response);			
			smart.setMaxFileSize(1024*1024*9);
			smart.setAllowedFilesList("jpg,png,gif");			
			smart.upload();
			Files files = smart.getFiles();
			com.jspsmart.upload.File file1 = files.getFile(0); 
			if (!file1.isMissing()) { 
				filename = file1.getFileName(); 
				file1.saveAs("upload/"+filename); 
				picture = filename; 
				String filePath = "/upload/"+ smart.getRequest().getParameter("old_picture") ;
				filePath = getServletContext().getRealPath(filePath);
				File oldfile = new File(filePath);
				oldfile.delete();
			}else {
				picture=smart.getRequest().getParameter("old_picture"); //沒有選圖片就存回舊檔名
				System.out.println("test8");
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		System.out.println("picture="+picture);
		int products_id = Integer.parseInt(smart.getRequest().getParameter("products_id"));
		String products_name = smart.getRequest().getParameter("products_name");
		int stock = Integer.parseInt(smart.getRequest().getParameter("stock"));			
		String updated_at = smart.getRequest().getParameter("updated_at");
		Product product = new Product(picture,products_id, products_name, stock, null, updated_at);
		productDao.updateProduct(product);
		response.sendRedirect("list");
	}		
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		int products_id = Integer.parseInt(request.getParameter("products_id"));
        Product existingProduct = productDao.selectProduct(products_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../backend/products_info/form.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);   
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("../backend/products_info/form.jsp");		
		dispatcher.forward(request, response);		
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String filename = "";
		try {
			//1）建立SmartUpload物件，
			smart = new SmartUpload();
			smart.initialize(getServletConfig(), request, response);
			//2）設定上傳限制（檔案的大小，型別）
			smart.setMaxFileSize(1024*1024*9);
			smart.setAllowedFilesList("jpg,png,gif");
			//3）呼叫SmartUpload物件的 upload()
			smart.upload();
			Files files = smart.getFiles();
			com.jspsmart.upload.File file1 = files.getFile(0); // 5.1）讀取本次上傳的檔案
			filename = file1.getFileName(); // 5.3）取得檔名
			file1.saveAs("upload/"+filename); // 5.4）呼叫檔案物件的 saveAs()方法
		} catch (SmartUploadException e) {			
			e.printStackTrace();
		}
		String picture = filename;		
		int products_id = Integer.parseInt(smart.getRequest().getParameter("products_id"));    	
    	String products_name = smart.getRequest().getParameter("products_name");
        int stock = Integer.parseInt(smart.getRequest().getParameter("stock"));   
        String created_at = smart.getRequest().getParameter("created_at");
        String updated_at = smart.getRequest().getParameter("updated_at");
        Product newProduct = new Product(picture, products_id, products_name, stock, created_at, updated_at);
        productDao.insertProduct(newProduct);
        response.sendRedirect("list");

    }	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		List < Product > listProduct = productDao.selectAllProduct();
		RequestDispatcher dispatcher;
		int totalrows = listProduct.size();
		request.setAttribute("totalrows", totalrows);
		request.setAttribute("listProduct", listProduct);
		dispatcher = request.getRequestDispatcher("../backend/products_info/list.jsp");		
		dispatcher.forward(request, response);
	    System.out.println("listcheck");
	}	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int products_id = Integer.parseInt(request.getParameter("products_id"));
		productDao.deleteProduct(products_id);
		response.sendRedirect("list");		
	}
	
}
