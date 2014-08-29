package net.lr.training.model;

import java.util.Collection;

public interface AddressService {
	Address find(String name);
	void create(String name, Address address);
	void delete(String name);
	Collection<Address> list();
}
