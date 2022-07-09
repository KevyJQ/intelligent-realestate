package com.intelligent.realestate.dao;

import com.intelligent.realestate.model.Arrendador;

public interface IntelligentRealEstateDao {
	
	public Arrendador findByBid(long arrendadorId);
	
}
