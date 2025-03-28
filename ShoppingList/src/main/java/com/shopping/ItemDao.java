package com.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
	private static final String url="jdbc:mysql://localhost:3306/gdb";
	private static final String uname="root";
	private static final String password="rootKSJ123";
	private String sql="";
	private PreparedStatement st=null;
	public Connection dbconnect() throws SQLException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	return DriverManager.getConnection(url,uname,password);
	}
	
	public Item search(String itemname) throws SQLException{
		Connection con=dbconnect();
		Item i=null;
		sql="select * from shopping where itemname=?";
		st=con.prepareStatement(sql);
		st.setString(1,itemname);
		ResultSet rs=st.executeQuery();
		 if(rs.next()) {
			 i=new Item();
			 i.setItemname(rs.getString("itemname"));
			 i.setQuantity(rs.getInt("quantity"));
			 i.setUnits(rs.getString("units"));
		 }
		 return i;		 
	}
	
	public boolean add(Item i) throws SQLException {
		Connection con=dbconnect();
		sql="insert into shopping(itemname,quantity,units) values(?,?,?)";
		st=con.prepareStatement(sql);
		st.setString(1,i.getItemname());
		st.setInt(2,i.getQuantity());
		st.setString(3,i.getUnits());
		int rowsAffected=st.executeUpdate();
		if(rowsAffected>0)
			return true;
		else
			return false;
	}
	
	public boolean delete(int id) throws SQLException {
		Connection con=dbconnect();
		sql="delete from shopping where slno=?";
		st=con.prepareStatement(sql);
		st.setInt(1,id);
		int rowsAffected=st.executeUpdate();
		if(rowsAffected>0)
			return true;
		else
			return false;
	}
	
	public boolean update(Item i, int id) throws SQLException {
		Connection con=dbconnect();
		sql="update shopping set itemname=?, quantity=?, units=? where slno=?";
		st=con.prepareStatement(sql);
		st.setString(1,i.getItemname());
		st.setInt(2,i.getQuantity());
		st.setString(3,i.getUnits());
		st.setInt(4,id);
		int rowsAffected=st.executeUpdate();
		if(rowsAffected>0)
			return true;
		else
			return false;
	}
	
	public List<Item> fetch() throws SQLException{
		List<Item> items=new ArrayList<>();
		Item i=null;
		Connection con=dbconnect();
		sql="select * from shopping";
		st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			 i=new Item();
			 i.setItemname(rs.getString("itemname"));
			 i.setQuantity(rs.getInt("quantity"));
			 i.setUnits(rs.getString("units"));
			 items.add(i);
		 }		
		return items;
	}
}
