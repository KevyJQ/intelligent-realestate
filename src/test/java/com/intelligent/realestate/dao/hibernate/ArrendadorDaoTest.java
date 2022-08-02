package com.intelligent.realestate.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Direccion;

public class ArrendadorDaoTest {

	private SessionFactory sessionFactory;
	private StandardServiceRegistry registry;
	
	@Test
	public void test() {
		
		init();
		Arrendador arrendador = new Arrendador();
		arrendador.setDireccion(new Direccion());
		
		arrendador.setNombre1("Test  nombre111 ");
		arrendador.setNombre2("Test nombre222 ");
		arrendador.setApellidoPaterno("Test Apellido");
		arrendador.setApellidoMaterno("Test materno");
		arrendador.setEdad(90);
		arrendador.setCorreo("test@gmail.com");
		arrendador.setCelular("659 864 9454");
		arrendador.getDireccion().setDireccion1("Test Direccion1 Hiber");
		arrendador.getDireccion().setDireccion2("Test Direccion2 Hiber");
		arrendador.getDireccion().setPais("Test Pais hiber");
		arrendador.getDireccion().setCiudad("Test Ciudad Hiber");
		arrendador.getDireccion().setEstado("Test Estado hiber");
		arrendador.getDireccion().setCodigoPostal("96283");

		Session session = geFactory().openSession();
		session.beginTransaction();
		session.save(arrendador);
		session.getTransaction().commit();
	}
	
	public SessionFactory geFactory() {
		return this.sessionFactory;
	}
	
	public void init() {		

		registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // se carga la configuracion hibernate
				.build();
		try {
			// se crea una fabrica de sessiones hibernate
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

}
