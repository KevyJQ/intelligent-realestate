package com.intelligent.realestate.dao.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.intelligent.realestate.dao.ArrendadorDao;
import com.intelligent.realestate.dao.hibernate.util.HibernateUtil;
import com.intelligent.realestate.model.Arrendador;

public class ArrendadorDaoImpl implements ArrendadorDao {

	@Override
	public Arrendador findById(long arrendadorId) {
		// TODO Implementar este metodo
		return null;
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
	public void insertRealEstate(Arrendador arrendador) {
		// TODO Implementar este metodo

	}

}
