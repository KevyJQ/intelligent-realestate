package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.RealEstateEstatus;

public class RealEstateDaoImpl implements RealEstateDao {

	@Override
	public void insertRealEstate(RealEstate realEstate) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(realEstate);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<RealEstate> selectRealEstate(String pais, String ciudad, RealEstateEstatus status) {
		List<RealEstate> realEstate;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		realEstate = session
				.createQuery("select re from RealEstate re where re.direccion.pais =:pais "
						+ "and re.direccion.ciudad = :ciudad " + "and re.estatus = :estatus", RealEstate.class)
				.setParameter("pais", pais).setParameter("ciudad", ciudad).setParameter("estatus", status).list();
		session.getTransaction().commit();
		session.close();

		return realEstate;
	}
	
//	public List<RealEstate> findAll(){
//		Session session = HibernateUtil.getSession();
//		session.beginTransaction();
//		
//		List<RealEstate> realestate
//	}
}