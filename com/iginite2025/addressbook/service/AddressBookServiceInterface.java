package com.iginite2025.addressbook.service;

import java.util.List;

import com.iginite2025.addressbook.entity.Address;

public interface AddressBookServiceInterface {
	void addAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(int id);
	Address getAddressById(int id);
	List<Address> getAddressByName(String name);
	List<Address> getAll();
	
	
}
