package net.lr.training.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.lr.training.model.Address;
import net.lr.training.model.AddressService;

public class AddressServiceImpl implements AddressService {
	Map<String, Address> addresses = new HashMap<>();

	@Override
	public Address find(String name) {
		return addresses.get(name);
	}

	@Override
	public void create(String name, Address address) {
		addresses.put(name, address);
	}

	@Override
	public void delete(String name) {
		addresses.remove(name);
	}

	@Override
	public Collection<Address> list() {
		return addresses.values();
	}

}
