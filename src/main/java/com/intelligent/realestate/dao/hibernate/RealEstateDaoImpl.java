package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelligent.realestate.dao.RealEstateDao;
import com.intelligent.realestate.model.RealEstate;
import com.intelligent.realestate.model.RealEstateEstatus;

@Repository
public class RealEstateDaoImpl implements RealEstateDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void insertRealEstate(RealEstate realEstate) {
//		Session session = HibernateUtil.getSession();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(realEstate);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<RealEstate> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<RealEstate> realEstates = session.createQuery("select r from RealEstate r").list();

		session.getTransaction().commit();
		session.close();

		return realEstates;
	}

	@Override
	public void delete(RealEstate realEstate) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		RealEstate realestate = session.find(RealEstate.class, realEstate.getIdRealEstate());
		session.delete(realestate);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void actualizarRealEstate(RealEstate realEstate) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(realEstate);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<RealEstate> selectRealEstate(String pais, String ciudad, RealEstateEstatus status) {
		List<RealEstate> realEstate;
		Session session = sessionFactory.openSession();
		// Session session = HibernateUtil.getSession();
		session.beginTransaction();

		realEstate = session
				.createQuery("select re from RealEstate re where re.direccion.pais =:pais "
						+ "and re.direccion.ciudad = :ciudad " + "and re.estatus = :estatus", RealEstate.class)
				.setParameter("pais", pais).setParameter("ciudad", ciudad).setParameter("estatus", status).list();
		session.getTransaction().commit();
		session.close();

		return realEstate;
	}

	@Override
	public RealEstate findById(long realEstateId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		RealEstate realEstate = session.find(RealEstate.class, realEstateId);

		session.beginTransaction().commit();
		session.close();
		return realEstate;
	}

}