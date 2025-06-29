package com.iginite2025.addressbookcontroller;

import java.sql.Connection;
import java.util.List;

import com.iginite2025.addressbook.entity.Address;
import com.iginite2025.addressbook.service.AddressBookService;
import com.iginite2025.addressbook.service.AddressBookServiceInterface;
import com.iginite2025.addressbook.util.AddressBookUtil;

public class MainAppController {

	public static void main(String[] args) {
		try (Connection conn = AddressBookUtil.getConnection()) {
          
			
			// using service layer
			AddressBookServiceInterface addressBookService =  new AddressBookService(conn);
			

            // Create an Address object to insert
			// Create 5 sample addresses
			for (int i = 1; i <= 5; i++) {
			    Address address = new Address();
			    address.setName("Person " + i);
			    address.setEmail_id("user" + i + "@example.com");
			    address.setPhoneNumber("123456789" + i);
			    address.setAddress("Address new street:  " + i);

			    // Insert using service
			    addressBookService.addAddress(address);
			}

            // Fetch all addresses and print them
            List<Address> allAddresses = addressBookService.getAll();
            for (Address addr : allAddresses) {
                System.out.println(
                        addr.getId() + " | " +
                        addr.getName() + " | " +
                        addr.getEmail_id() + " | " +
                        addr.getPhoneNumber() + " | " +
                        addr.getAddress()
                );
            }
            
            Address addressToUpdate = new Address();
            addressToUpdate.setId(12);
            addressToUpdate.setName("Person5");
            addressToUpdate.setEmail_id("user5@example.com");
            addressToUpdate.setPhoneNumber("1234567896");
            addressToUpdate.setAddress("Address new street: 6");
            addressBookService.updateAddress(addressToUpdate);

            // Fetch all addresses and print them
            System.out.println("<-AFTER UPDATION->");
            allAddresses = addressBookService.getAll();
            for (Address addr : allAddresses) {
                System.out.println(
                        addr.getId() + " | " +
                        addr.getName() + " | " +
                        addr.getEmail_id() + " | " +
                        addr.getPhoneNumber() + " | " +
                        addr.getAddress()
                );
            }

            
            
            System.out.println("<-AFTER DELETION->");
            addressBookService.deleteAddress(12);
            allAddresses = addressBookService.getAll();
            for (Address addr : allAddresses) {
                System.out.println(
                        addr.getId() + " | " +
                        addr.getName() + " | " +
                        addr.getEmail_id() + " | " +
                        addr.getPhoneNumber() + " | " +
                        addr.getAddress()
                );
            }
            
            
            System.out.println("<-SEARCH BY ID->");
            Address foundById = addressBookService.getAddressById(11);
            if (foundById != null) {
                System.out.println(
                    foundById.getId() + " | " +
                    foundById.getName() + " | " +
                    foundById.getEmail_id() + " | " +
                    foundById.getPhoneNumber() + " | " +
                    foundById.getAddress()
                );
            } else {
                System.out.println("No record found with ID 12.");
            }

            System.out.println("\n<-SEARCH BY NAME->");
            List<Address> foundByName = addressBookService.getAddressByName("Person 1");
            for (Address addr : foundByName) {
                System.out.println(
                    addr.getId() + " | " +
                    addr.getName() + " | " +
                    addr.getEmail_id() + " | " +
                    addr.getPhoneNumber() + " | " +
                    addr.getAddress()
                );
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
