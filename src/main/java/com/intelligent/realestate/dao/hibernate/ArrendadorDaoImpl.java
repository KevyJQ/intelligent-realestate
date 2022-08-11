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
		session.beginTransaction();

		Arrendador arrendador = session.find(Arrendador.class, arrendadorId);

		session.getTransaction().commit();
		session.close();

		return arrendador;
	}

	@Override
	public List<Arrendador> findByNameAndLasName(String name, String apellidoMaterno, String apellidoPaterno) {
		List<Arrendador> arrendadores;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		arrendadores = session
				.createQuery("select a from Arrendador a where a.nombre1 = :nombre1 "
						+ "and a.apellidoPaterno = :apellidoPaterno " + "and a.apellidoMaterno = :apellidoMaterno",
						Arrendador.class)
				.setParameter("nombre1", name).setParameter("apellidoPaterno", apellidoPaterno)
				.setParameter("apellidoMaterno", apellidoMaterno).list();

		session.getTransaction().commit();
		session.close();

		return arrendadores;
	}

	@Override
	public void insertArrendador(Arrendador arrendador) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(arrendador);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void insertRealEstate(RealEstate realEstate) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(realEstate);

		session.getTransaction().commit();
		session.close();
	}

}
