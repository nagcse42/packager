package com.mobiquity.packager.model;

import java.util.Objects;

/**
 * POJO for data wrapping
 * 
 * @author Nagarjuna Paritala.
 */

public class PackageItem implements Comparable<PackageItem> {
	private Integer index;
	private Double weight;
	private Integer cost;

	public PackageItem(Integer index, Double weight, Integer cost) {
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getIndex() {
		return index;
	}

	public Double getWeight() {
		return weight;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return index.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PackageItem item = (PackageItem) o;
		return Objects.equals(index, item.index) && Objects.equals(weight, item.weight)
				&& Objects.equals(cost, item.cost);
	}

	@Override
	public int hashCode() {
		return Objects.hash(index, weight, cost);
	}

	@Override
	public int compareTo(@SuppressWarnings("NullableProblems") PackageItem o) {
		if (Objects.equals(this.cost, o.cost))
			return this.weight > o.weight ? 1 : -1;
		else
			return this.cost > o.cost ? -1 : 1;
	}

}