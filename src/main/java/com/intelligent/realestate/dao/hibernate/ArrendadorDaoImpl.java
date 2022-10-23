package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.model.Arrendador;

@Repository
public class ArrendadorDaoImpl implements ArrendadorDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Arrendador buscarPorId(long arrendadorId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Arrendador arrendador = session.find(Arrendador.class, arrendadorId);

		session.getTransaction().commit();
		session.close();

		return arrendador;
	}

	@Override
	public List<Arrendador> buscarPorNombreApellidoMaternoApellidoPaterno(String nombre, String apellidoMaterno,
			String apellidoPaterno) {
		List<Arrendador> arrendadores;
		Session session = sessionFactory.openSession(); // Spring
		session.beginTransaction();

		arrendadores = session
				.createQuery(
						"select a from Arrendador a where a.nombre1 = :nombre1 "
								+ "and a.apellidoPaterno = :apellidoPaterno and a.apellidoMaterno = :apellidoMaterno",
						Arrendador.class)
				.setParameter("nombre1", nombre).setParameter("apellidoPaterno", apellidoPaterno)
				.setParameter("apellidoMaterno", apellidoMaterno).list();

		session.getTransaction().commit();
		session.close();

		return arrendadores;
	}

	@Override
	public void guardarArrendador(Arrendador arrendador) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(arrendador);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void actualizarArrendador(Arrendador arrendador) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(arrendador);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Arrendador> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Arrendador> arrendadores = session.createQuery("select a from Arrendador a").list();

		session.getTransaction().commit();
		session.close();

		return arrendadores;
	}

	@Override
	public void delete(Arrendador arrendador) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Arrendador arren = session.find(Arrendador.class, arrendador.getIdArrendador());
		session.delete(arren);

		session.getTransaction().commit();
		session.close();
	}

}
