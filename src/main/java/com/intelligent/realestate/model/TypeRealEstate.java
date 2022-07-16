package com.intelligent.realestate.model;

public enum TypeRealEstate {
	CASA(1), DEPARTAMENTO(2), TERRENO(3), OFICINA(4);

	private int id;

	TypeRealEstate(int i) {
		id = i;
	}

	public int getId() {
		return id;
	}
}
