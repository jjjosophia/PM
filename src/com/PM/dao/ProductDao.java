package com.PM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.PM.model.Product;


public class ProductDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/acc?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
	private String jdbcname = "acc";
	private String jdbcPass = "acc";
	private static final String INSERT_PRODUCT_SQL= "INSERT INTO products_info (picture, products_id, products_name, stock, created_at, updated_at) VALUE(?,?,?,?,?,?);";
	private static final String SELECT_PRODUCT_BY_ID="select * from products_info where products_id=?"; 
	private static final String SELECT_ALL_PRODUCTS ="select * from products_info;";
	private static final String DELETE_PRODUCTS_SQL ="delete from products_info where products_id=?;";	    
	private static final String UPDATE_PRODUCTS_SQL ="update products_info set picture = ?, products_name= ? ,stock= ? ,updated_at= ? where products_id = ?;";
 
	public ProductDao() {}
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL,jdbcname,jdbcPass);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public List< Product > selectAllProduct(){
		List< Product > products= new ArrayList<>();

		try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_PRODUCTS);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String picture = rs.getString("picture");
				int products_id= rs.getInt("products_id");
				String products_name = rs.getString("products_name");				
				int stock = rs.getInt("stock");				
				String created_at = rs.getString("created_at");
				String updated_at = rs.getString("updated_at");
				products.add(new Product( picture, products_id, products_name, stock, created_at, updated_at));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
        	preparedStatement.setString(1, product.getPicture());
        	preparedStatement.setInt(2, product.getProducts_id());
            preparedStatement.setString(3, product.getProducts_name());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setString(5, product.getCreated_at());
            preparedStatement.setString(6, product.getUpdated_at());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public boolean updateProduct(Product product) throws SQLException{
		boolean rowUpdated;
		try( Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);){
//			statement.setInt(1, product.getProduct_categories_id());
			statement.setString(1, product.getPicture());			
			statement.setString(2, product.getProducts_name());
			statement.setInt(3, product.getStock());
			statement.setString(4, product.getUpdated_at());	
			statement.setInt(5, product.getProducts_id());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public Product selectProduct(int products_id){
        Product product = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, products_id);            
            ResultSet rsProduct = preparedStatement.executeQuery();
            while (rsProduct.next()) {
            	String picture = rsProduct.getString("picture");
                int p_id = rsProduct.getInt("products_id");
                String products_name = rsProduct.getString("products_name");
                int stock = rsProduct.getInt("stock");
                String created_at = rsProduct.getString("created_at");
                String updated_at = rsProduct.getString("updated_at");
                System.out.println(created_at);
                product = new Product(picture, p_id, products_name, stock, created_at,updated_at);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }
	public boolean deleteProduct(int products_id) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);){
			statement.setInt(1, products_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
