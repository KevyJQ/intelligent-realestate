package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intelligent.realestate.dao.ArrendatarioDao;
import com.intelligent.realestate.model.Arrendatario;

@Repository
public class ArrendatarioDaoImpl implements ArrendatarioDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Arrendatario findById(long arrendatarioId) {
		Session session = sessionFactory.openSession(); // Spring
		// Session session = HibernateUtil.getSession(); //Hibernate
		session.beginTransaction();

		Arrendatario arrendatario = session.find(Arrendatario.class, arrendatarioId);

		session.getTransaction().commit();
		session.close();

		return arrendatario;
	}

	@Override
	public List<Arrendatario> findByNameAndLasName(String name, String apellidoPaterno, String apellidoMaterno) {
		List<Arrendatario> arrendatario;
		Session session = sessionFactory.openSession(); // Spring
		// Session session = HibernateUtil.getSession();
		session.beginTransaction();

		arrendatario = session
				.createQuery(
						"select a from Arrendatario a where a.nombre1 = :nombre1 "
								+ "and a.apellidoPaterno = :apellidoPaterno and a.apellidoMaterno = :apellidoMaterno",
						Arrendatario.class)
				.setParameter("nombre1", name).setParameter("apellidoPaterno", apellidoPaterno)
				.setParameter("apellidoMaterno", apellidoMaterno).list();

		session.getTransaction().commit();
		session.close();

		return arrendatario;
	}

	@Override
	public void insertArrendatario(Arrendatario arrendatario) {
		Session session = sessionFactory.openSession();
		// Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(arrendatario);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Arrendatario> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Arrendatario> arrendatarios = session.createQuery("select a from Arrendatario a").list();

		session.getTransaction().commit();
		session.close();

		return arrendatarios;
	}

	@Override
	public void delete(Arrendatario arrendatario) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Arrendatario arrenda = session.find(Arrendatario.class, arrendatario.getIdArrendatario());
		session.delete(arrenda);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void actualizarArrendatario(Arrendatario arrendatario) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(arrendatario);

		session.getTransaction().commit();
		session.close();
	}
}
