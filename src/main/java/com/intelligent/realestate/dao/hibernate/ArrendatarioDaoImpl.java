package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.Arrendatario;

public class ArrendatarioDaoImpl implements ArrendatarioDao {

	@Override
	public Arrendatario findById(long arrendatarioId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Arrendatario arrendatario = session.find(Arrendatario.class, arrendatarioId);

		session.getTransaction().commit();
		session.close();

		return arrendatario;
	}

	@Override
	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno) {
		List<Arrendatario> arrendatario;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		arrendatario = session
				.createQuery(
						"select a from Arrendatario a where a.nombre1 = :nombre1 "
								+ "and a.apellidoPaterno = :apellidoPaterno and a.apellidoMaterno = :apellidoMaterno",
						Arrendatario.class)
				.setParameter("nombre1", name)
				.setParameter("apellidoPaterno", apellidoPaterno)
				.setParameter("apellidoMaterno", apellidoMaterno).list();

		session.getTransaction().commit();
		session.close();

		return arrendatario;
	}

	@Override
	public void insertArrendatario(Arrendatario arrendatario) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(arrendatario);

		session.getTransaction().commit();
		session.close();
	}
}
