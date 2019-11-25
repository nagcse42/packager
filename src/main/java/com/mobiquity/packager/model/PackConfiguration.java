package com.mobiquity.packager.model;

import java.util.List;

/**
 * POJO for Package configuration object
 * @author Nagarjuna Paritala
 *
 */
public class PackConfiguration {

	private int capacity;
	private List<PackageItem> packItems;
	
	public PackConfiguration(int capacity, List<PackageItem> items) {
		super();
		this.capacity = capacity;
		this.packItems = items;
	}

	public PackConfiguration() {

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<PackageItem> getItems() {
		return packItems;
	}

	public void setItems(List<PackageItem> packItems) {
		this.packItems = packItems;
	}	
}