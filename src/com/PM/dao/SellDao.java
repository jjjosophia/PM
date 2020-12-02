package com.PM.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.PM.model.Sell;


public class SellDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/acc?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
	private String jdbcname = "acc";
	private String jdbcPass = "acc";
	
	private static final String SELECT_ALL_SELLS ="select * from sell;";
	private static final String INSERT_SELL_SQL= "INSERT INTO SELL (shop_id, shop_sell_id, products_id, products_price, sell_qty, sell_status, created_at, updated_at) VALUE(?,?,?,?,?,?,?,?);";
	private static final String SELECT_SELL_BY_ID="select * from sell where id=?"; 
	private static final String UPDATE_SELL_SQL ="update sell set shop_id = ?, shop_sell_id= ? ,products_id= ? ,products_price= ?,sell_qty= ?,sell_status= ?,updated_at= ? where id = ?;";
	private static final String DELETE_SELL_SQL ="delete from sell where id=?;";	    
 
	public SellDao() {}
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
	public List< Sell > selectAllSells(){
		List< Sell > sell= new ArrayList<>();

		try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_SELLS);){
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {				
				int id= rs.getInt("id");
				int shop_id= rs.getInt("shop_id");				
				String shop_sell_id = rs.getString("shop_sell_id");				
				int products_id = rs.getInt("products_id");				
				int products_price = rs.getInt("products_price");				
				int sell_qty = rs.getInt("sell_qty");				
				String sell_status = rs.getString("sell_status");
				String created_at = rs.getString("created_at");
				String updated_at = rs.getString("updated_at");
				sell.add(new Sell( id, shop_id, shop_sell_id, products_id, products_price, sell_qty,sell_status,created_at,updated_at));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sell;
	}
	public void insertSell(Sell sell) throws SQLException {
        System.out.println(INSERT_SELL_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SELL_SQL)) {
        	preparedStatement.setInt(1, sell.getShop_id());
            preparedStatement.setString(2, sell.getShop_sell_id());
            preparedStatement.setInt(3, sell.getProducts_id());
            preparedStatement.setInt(4, sell.getProducts_price());
            preparedStatement.setInt(5, sell.getSell_qty());
            preparedStatement.setString(6, sell.getSell_status());
            preparedStatement.setString(7, sell.getCreated_at());
            preparedStatement.setString(8, sell.getUpdated_at());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public Sell selectSell(int id){
        Sell sell = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SELL_BY_ID);) {
            preparedStatement.setInt(1, id);            
            ResultSet rsSell = preparedStatement.executeQuery();
            while (rsSell.next()) {            	
            	int id1 = rsSell.getInt("id");
                int shop_id = rsSell.getInt("shop_id");
                String shop_sell_id = rsSell.getString("shop_sell_id");
                int products_id = rsSell.getInt("products_id");
                int products_price = rsSell.getInt("products_price");
                int sell_qty = rsSell.getInt("sell_qty");
                String sell_status = rsSell.getString("sell_status");
                String created_at = rsSell.getString("created_at");
                String updated_at = rsSell.getString("updated_at");
                System.out.println(created_at);
                sell = new Sell(id1, shop_id, shop_sell_id, products_id,products_price,sell_qty,sell_status,created_at,updated_at);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sell;
    }
	 public boolean updateSell(Sell sell) throws SQLException{
	        boolean rowUpdated;
	        try( Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SELL_SQL);){
	            statement.setInt(1, sell.getShop_id());
	            statement.setString(2, sell.getShop_sell_id());
	            statement.setInt(3, sell.getProducts_id());
	            statement.setInt(4, sell.getProducts_price());
	            statement.setInt(5, sell.getSell_qty());
	            statement.setString(6, sell.getSell_status());
	            statement.setString(7, sell.getUpdated_at());
	            statement.setInt(8, sell.getId());
	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	 
	 public boolean deleteSell(int id) throws SQLException{
			boolean rowDeleted;
			try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SELL_SQL);){
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
}
