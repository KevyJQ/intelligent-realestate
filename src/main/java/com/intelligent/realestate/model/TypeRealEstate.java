package com.intelligent.realestate.model;

public enum TypeRealEstate {
	CASA(0), DEPARTAMENTO(1), TERRENO(2), OFICINA(3);

	private int id;

	TypeRealEstate(int i) {
		id = i;
	}

	public int getId() {
		return id;
	}
}
