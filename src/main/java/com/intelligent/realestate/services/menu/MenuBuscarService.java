package com.intelligent.realestate.services.menu;

import java.util.Optional;

public interface MenuBuscarService<T> {

	/*
	 * Despliega menu para buscar objeto de tipo T.
	 *
	 * @return el objecto T si lo encontro, de otra manera null.
	 */
	public Optional<T> buscarMenu();

}
