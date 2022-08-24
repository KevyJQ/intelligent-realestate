package com.intelligent.realestate.dao;

import java.util.List;

import com.intelligent.realestate.model.Arrendador;
import com.intelligent.realestate.model.Arrendatario;
import com.intelligent.realestate.model.Contrato;

public interface ContratoDao {

	public void guardarContrato(Contrato contrato);

	public List<Contrato> buscarPorArrendador(Arrendador arrendador);

	public List<Contrato> buscarPorArrendatario(Arrendatario arrendatario);

}
