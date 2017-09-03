package br.capiroto.names.service;

import java.util.List;
import java.util.Set;

import br.capiroto.names.pojo.CapirotoNames;

public interface CapirotoService {

	Set<CapirotoNames> findAll();
	
	List<CapirotoNames> findAllList();
	
	Set<CapirotoNames> findByNome(String nome);
	
	CapirotoNames save(CapirotoNames capirotoNames);
	
	CapirotoNames getRandomName();

	void deleteRow(CapirotoNames capirotoNames);
	
}