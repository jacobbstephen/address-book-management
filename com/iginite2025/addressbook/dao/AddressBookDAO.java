package com.iginite2025.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iginite2025.addressbook.entity.Address;
// this class basically does all the DB operations
public class AddressBookDAO implements AddressBookDAOInterface {
	private Connection connection;

	public AddressBookDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void add(Address address) {
		String sql = "INSERT INTO ADDRESS_BOOK (NAME, EMAIL, PHONE_NUMBER, ADDRESS) VALUES (?, ?, ?, ?) ";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setString(1, address.getName());
			preparedStatement.setString(2, address.getEmail_id());
			preparedStatement.setString(3, address.getPhoneNumber());
			preparedStatement.setString(4, address.getAddress());
			
			preparedStatement.executeUpdate();
			System.out.println("<-DATA STORED IN THE DATABASE->");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Address address) {
		String sql = "UPDATE ADDRESS_BOOK SET NAME = ?, EMAIL = ?, PHONE_NUMBER = ?, ADDRESS = ? WHERE ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setString(1, address.getName());
			preparedStatement.setString(2, address.getEmail_id());
			preparedStatement.setString(3, address.getPhoneNumber());
			preparedStatement.setString(4, address.getAddress());
			preparedStatement.setInt(5, address.getId());
			preparedStatement.executeUpdate();
			System.out.println("<-DATA UPDATED IN THE DATABASE->");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM ADDRESS_BOOK WHERE ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
	
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			System.out.println("<-DATA DELETED IN THE DATABASE WITH ID("  + id + ") ->");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Address searchById(int id) {
		String sql = "SELECT * FROM ADDRESS_BOOK WHERE ID = ?";
		Address address = null;
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				address = new Address();
				address.setId(resultSet.getInt("ID"));
				address.setEmail_id(resultSet.getString("EMAIL"));
				address.setName(resultSet.getString("NAME"));
				address.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
				address.setAddress(resultSet.getString("ADDRESS"));
				
			}
			System.out.println("<-DATA SEARCHED BASED ON ID FROM THE DATABASE->");
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<Address> searchByName(String name) {
		List<Address> list = new ArrayList<Address>();
		String sql = "SELECT * FROM ADDRESS_BOOK WHERE NAME LIKE ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, "%" + name + "%");

	        try (ResultSet rs = preparedStatement.executeQuery()) {
	            while (rs.next()) {
	                Address address = new Address();
	                address.setId(rs.getInt("ID"));
	                address.setName(rs.getString("NAME"));
	                address.setEmail_id(rs.getString("EMAIL"));
	                address.setPhoneNumber(rs.getString("PHONE_NUMBER"));
	                address.setAddress(rs.getString("ADDRESS"));
	                list.add(address);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		System.out.println("<-DATA SEARCHED BASED ON NAME FROM THE DATABASE->");

		return list;
	}
	

	@Override
	public List<Address> getAll() {
		List<Address> addressList = new ArrayList<Address>();
		String sql = "SELECT * FROM ADDRESS_BOOK";
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()
				){
			while(resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getInt("ID"));
				address.setEmail_id(resultSet.getString("EMAIL"));
				address.setName(resultSet.getString("NAME"));
				address.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
				address.setAddress(resultSet.getString("ADDRESS"));
				addressList.add(address);
			}
			
			System.out.println("<-DATA RETERIVED FROM THE DATABASE->");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return addressList;
	}

}
