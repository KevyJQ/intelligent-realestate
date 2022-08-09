package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.RealEstate;

public class ArrendadorDaoImpl implements ArrendadorDao {

	@Override
	public Arrendador findById(long arrendadorId) {
		Session session = HibernateUtil.getSession();

		Arrendador arrendador = session.find(Arrendador.class, arrendadorId);

		return arrendador;
	}

	@Override
	public List<Arrendador> findByNameAndLasName(String name, String apelledoMaterno, String apellidoPaterno) {
		// TODO Implementar este metodo
		return null;
	}

	@Override
	public void insertArrendador(Arrendador arrendador) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(arrendador);
		session.getTransaction().commit();
	}

	@Override
	public void insertRealEstate(RealEstate realEstate) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(realEstate);
		session.getTransaction().commit();
	}

}
