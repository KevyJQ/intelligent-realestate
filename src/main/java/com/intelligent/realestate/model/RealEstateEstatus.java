package com.intelligent.realestate.model;

public enum RealEstateEstatus {
	DISPONIBLE("Disponible"), RENTADA("Rentada"), NO_DISPONIBLE("No Disponible");

	private String name;

	private RealEstateEstatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
