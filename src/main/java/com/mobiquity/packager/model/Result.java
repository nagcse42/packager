package com.mobiquity.packager.model;

import java.util.List;

/**
 * POJO for Result object
 * @author Nagarjuna Paritala
 *
 */
public class Result {
	
	public List<PackageItem> packItems;
	public int value;
	
	public Result(List<PackageItem> items, int value) {
		this.packItems = items;
		this.value = value;
	}

	public List<PackageItem> getItems() {
		return packItems;
	}

	public void setItems(List<PackageItem> packItems) {
		this.packItems = packItems;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Solution [items=" + packItems + ", value=" + value + "]";
	}
	
}