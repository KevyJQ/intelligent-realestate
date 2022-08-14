package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.Arrendador;

public class ArrendadorDaoImpl implements ArrendadorDao {

	@Override
	public Arrendador buscarPorId(long arrendadorId) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		Arrendador arrendador = session.find(Arrendador.class, arrendadorId);

		session.getTransaction().commit();
		session.close();

		return arrendador;
	}

	@Override
	public List<Arrendador> buscarPorNombreApellidoMaternoApellidoPaterno(String nombre, String apellidoMaterno, String apellidoPaterno) {
		List<Arrendador> arrendadores;
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		arrendadores = session
				.createQuery("select a from Arrendador a where a.nombre1 = :nombre1 "
						+ "and a.apellidoPaterno = :apellidoPaterno "
						+ "and a.apellidoMaterno = :apellidoMaterno",
						Arrendador.class)
				.setParameter("nombre1", nombre)
				.setParameter("apellidoPaterno", apellidoPaterno)
				.setParameter("apellidoMaterno", apellidoMaterno).list();

		session.getTransaction().commit();
		session.close();

		return arrendadores;
	}

	@Override
	public void guardarArrendador(Arrendador arrendador) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(arrendador);

		session.getTransaction().commit();
		session.close();
	}
}
