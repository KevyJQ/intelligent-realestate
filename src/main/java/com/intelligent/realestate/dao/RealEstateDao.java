package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.RealEstateEstatus;

public interface RealEstateDao {

	List<RealEstate> selectRealEstate(String pais, String ciudad, RealEstateEstatus realEstateEstatus);

	public void insertRealEstate(RealEstate realEstate);

	public List<RealEstate> findAll();

	public void delete(RealEstate realEstate);

	public void actualizarRealEstate(RealEstate realEstate);
	
	public RealEstate findById(long realEstateId);
}
