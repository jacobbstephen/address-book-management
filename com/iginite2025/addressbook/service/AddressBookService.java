package com.iginite2025.addressbook.service;

import java.sql.Connection;
import java.util.List;

import com.iginite2025.addressbook.dao.AddressBookDAO;
import com.iginite2025.addressbook.dao.AddressBookDAOInterface;
import com.iginite2025.addressbook.entity.Address;

public class AddressBookService implements AddressBookServiceInterface {
	private AddressBookDAOInterface dao;
	
	public AddressBookService(Connection conn) {
		super();
		this.dao = new AddressBookDAO(conn);
	}

	@Override
	public void addAddress(Address address) {
		dao.add(address);
		
	}

	@Override
	public void updateAddress(Address address) {
		dao.update(address);
		
	}

	@Override
	public void deleteAddress(int id) {
		dao.delete(id);
		
	}

	@Override
	public Address getAddressById(int id) {
		return dao.searchById(id);
	}

	@Override
	public List<Address> getAddressByName(String name) {
		return dao.searchByName(name);
	}

	@Override
	public List<Address> getAll() {
		return dao.getAll();
	}

}
