package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.RealEstate;

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
	public List<RealEstate> selectRealEstate(String pais, String ciudad, String status) {
		List<RealEstate> realEstate;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		realEstate = session
				.createQuery("select re from Real_Estate re where re.pais =:pais "
						+ "and re.ciudad = :ciudad "
						+ "and re.status = :status",
						RealEstate.class)
				.setParameter("pais", pais)
				.setParameter("ciudad", ciudad)
				.setParameter("status", status).list();
		session.getTransaction().commit();
		session.close();

		return realEstate;
	}
}
