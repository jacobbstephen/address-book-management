package com.iginite2025.addressbook.dao;

import java.util.List;

import com.iginite2025.addressbook.entity.Address;

public interface AddressBookDAOInterface {
	void add(Address address);
	void update(Address address);
	void delete(int id);
	Address searchById(int id);
	List<Address> searchByName(String name);
	List<Address> getAll();
}
