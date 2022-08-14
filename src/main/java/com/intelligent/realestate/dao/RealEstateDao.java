package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.RealEstate;

public interface RealEstateDao {

	List<RealEstate> selectRealEstate(String pais, String ciudad, String status);

	public void insertRealEstate(RealEstate realEstate);
}
